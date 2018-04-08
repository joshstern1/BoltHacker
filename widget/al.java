package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class al extends C0708j {
    private int f2377j;
    private int f2378k;
    private LayoutInflater f2379l;

    @Deprecated
    public al(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2378k = i;
        this.f2377j = i;
        this.f2379l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo684a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2379l.inflate(this.f2377j, viewGroup, false);
    }

    public View mo685b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2379l.inflate(this.f2378k, viewGroup, false);
    }
}
