package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;

public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct = false;
    private CursorFactory mFactory = null;
    private Map<String, String> mProjectionMap = null;
    private boolean mStrictProjectionMap;
    private String mTables = "";
    private StringBuilder mWhereClause = null;

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public String getTables() {
        return this.mTables;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setCursorFactory(CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setStrictProjectionMap(boolean z) {
        this.mStrictProjectionMap = z;
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        } else if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
            StringBuilder stringBuilder = new StringBuilder(120);
            stringBuilder.append("SELECT ");
            if (z) {
                stringBuilder.append("DISTINCT ");
            }
            if (strArr == null || strArr.length == 0) {
                stringBuilder.append("* ");
            } else {
                appendColumns(stringBuilder, strArr);
            }
            stringBuilder.append("FROM ");
            stringBuilder.append(str);
            appendClause(stringBuilder, " WHERE ", str2);
            appendClause(stringBuilder, " GROUP BY ", str3);
            appendClause(stringBuilder, " HAVING ", str4);
            appendClause(stringBuilder, " ORDER BY ", str5);
            appendClause(stringBuilder, " LIMIT ", str6);
            return stringBuilder.toString();
        } else {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str6);
        }
    }

    private static void appendClause(StringBuilder stringBuilder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
        }
    }

    private static void appendClauseEscapeClause(StringBuilder stringBuilder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str);
            DatabaseUtils.appendEscapedSQLString(stringBuilder, str2);
        }
    }

    public static void appendColumns(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(str);
            }
        }
        stringBuilder.append(' ');
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (this.mTables == null) {
            return null;
        }
        String buildQuery = buildQuery(strArr, str, strArr2, str2, str3, str4, str5);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Performing query: " + buildQuery);
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables));
    }

    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        String[] computeProjection = computeProjection(strArr);
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = (this.mWhereClause == null || this.mWhereClause.length() <= 0) ? null : 1;
        if (obj != null) {
            stringBuilder.append(this.mWhereClause.toString());
            stringBuilder.append(')');
        }
        if (str != null && str.length() > 0) {
            if (obj != null) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append('(');
            stringBuilder.append(str);
            stringBuilder.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, computeProjection, stringBuilder.toString(), str2, str3, str4, str5);
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String[] strArr2, String str4, String str5) {
        int length = strArr.length;
        String[] strArr3 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str6 = strArr[i2];
            if (str6.equals(str)) {
                strArr3[i2] = "'" + str2 + "' AS " + str;
            } else if (i2 <= i || set.contains(str6)) {
                strArr3[i2] = str6;
            } else {
                strArr3[i2] = "NULL AS " + str6;
            }
        }
        return buildQuery(strArr3, str3, strArr2, str4, str5, null, null);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(str3);
            }
            stringBuilder.append(strArr[i]);
        }
        appendClause(stringBuilder, " ORDER BY ", str);
        appendClause(stringBuilder, " LIMIT ", str2);
        return stringBuilder.toString();
    }

    private String[] computeProjection(String[] strArr) {
        int i;
        if (strArr == null || strArr.length <= 0) {
            if (this.mProjectionMap == null) {
                return null;
            }
            Set<Entry> entrySet = this.mProjectionMap.entrySet();
            strArr = new String[entrySet.size()];
            i = 0;
            for (Entry entry : entrySet) {
                if (!((String) entry.getKey()).equals("_count")) {
                    int i2 = i + 1;
                    strArr[i] = (String) entry.getValue();
                    i = i2;
                }
            }
            return strArr;
        } else if (this.mProjectionMap == null) {
            return strArr;
        } else {
            String[] strArr2 = new String[strArr.length];
            int length = strArr.length;
            for (i = 0; i < length; i++) {
                String str = strArr[i];
                String str2 = (String) this.mProjectionMap.get(str);
                if (str2 != null) {
                    strArr2[i] = str2;
                } else if (this.mStrictProjectionMap || !(str.contains(" AS ") || str.contains(" as "))) {
                    throw new IllegalArgumentException("Invalid column " + strArr[i]);
                } else {
                    strArr2[i] = str;
                }
            }
            return strArr2;
        }
    }
}
