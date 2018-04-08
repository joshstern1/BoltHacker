package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class C0735l extends Filter {
    C0707a f2434a;

    interface C0707a {
        Cursor mo680a();

        Cursor mo681a(CharSequence charSequence);

        void mo682a(Cursor cursor);

        CharSequence mo683c(Cursor cursor);
    }

    C0735l(C0707a c0707a) {
        this.f2434a = c0707a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2434a.mo683c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f2434a.mo681a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f2434a.mo680a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f2434a.mo682a((Cursor) filterResults.values);
        }
    }
}
