package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class SQLiteContentHelper {
    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            MemoryFile simpleQueryForBlobMemoryFile = simpleQueryForBlobMemoryFile(sQLiteDatabase, str, strArr);
            if (simpleQueryForBlobMemoryFile == null) {
                throw new FileNotFoundException("No results.");
            }
            try {
                Method declaredMethod = simpleQueryForBlobMemoryFile.getClass().getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
                declaredMethod.setAccessible(true);
                parcelFileDescriptor = (ParcelFileDescriptor) declaredMethod.invoke(simpleQueryForBlobMemoryFile, new Object[0]);
            } catch (Exception e) {
                Log.i("SQLiteContentHelper", "SQLiteCursor.java: " + e);
            }
            return new AssetFileDescriptor(parcelFileDescriptor, 0, (long) simpleQueryForBlobMemoryFile.length());
        } catch (IOException e2) {
            throw new FileNotFoundException(e2.toString());
        }
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws IOException {
        MemoryFile memoryFile = null;
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    byte[] blob = rawQuery.getBlob(0);
                    if (blob == null) {
                        rawQuery.close();
                    } else {
                        memoryFile = new MemoryFile(null, blob.length);
                        memoryFile.writeBytes(blob, 0, 0, blob.length);
                        rawQuery.close();
                    }
                }
            } finally {
                rawQuery.close();
            }
        }
        return memoryFile;
    }
}
