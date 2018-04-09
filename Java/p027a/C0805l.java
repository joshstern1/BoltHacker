package android.support.v7.p027a;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.p027a.C0798e.C0795a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class C0805l extends CursorAdapter {
    final /* synthetic */ ListView f2681a;
    final /* synthetic */ C0798e f2682b;
    final /* synthetic */ C0795a f2683c;
    private final int f2684d;
    private final int f2685e;

    C0805l(C0795a c0795a, Context context, Cursor cursor, boolean z, ListView listView, C0798e c0798e) {
        this.f2683c = c0795a;
        this.f2681a = listView;
        this.f2682b = c0798e;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f2684d = cursor2.getColumnIndexOrThrow(this.f2683c.f2594I);
        this.f2685e = cursor2.getColumnIndexOrThrow(this.f2683c.f2595J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f2684d));
        this.f2681a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2685e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2683c.f2600b.inflate(this.f2682b.f2634I, viewGroup, false);
    }
}
