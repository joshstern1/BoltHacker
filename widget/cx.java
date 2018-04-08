package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p021b.C0307a;
import android.support.v4.widget.al;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class cx extends al implements OnClickListener {
    private final SearchManager f3791j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f3792k;
    private final SearchableInfo f3793l;
    private final Context f3794m;
    private final WeakHashMap<String, ConstantState> f3795n;
    private final int f3796o;
    private boolean f3797p = false;
    private int f3798q = 1;
    private ColorStateList f3799r;
    private int f3800s = -1;
    private int f3801t = -1;
    private int f3802u = -1;
    private int f3803v = -1;
    private int f3804w = -1;
    private int f3805x = -1;

    private static final class C0980a {
        public final TextView f3786a;
        public final TextView f3787b;
        public final ImageView f3788c;
        public final ImageView f3789d;
        public final ImageView f3790e;

        public C0980a(View view) {
            this.f3786a = (TextView) view.findViewById(16908308);
            this.f3787b = (TextView) view.findViewById(16908309);
            this.f3788c = (ImageView) view.findViewById(16908295);
            this.f3789d = (ImageView) view.findViewById(16908296);
            this.f3790e = (ImageView) view.findViewById(C0836f.edit_query);
        }
    }

    public cx(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f3792k = searchView;
        this.f3793l = searchableInfo;
        this.f3796o = searchView.getSuggestionCommitIconResId();
        this.f3794m = context;
        this.f3795n = weakHashMap;
    }

    public void m7050a(int i) {
        this.f3798q = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor mo681a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f3792k.getVisibility() != 0 || this.f3792k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m7046a(this.f3793l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m7042d(mo680a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m7042d(mo680a());
    }

    private void m7042d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void mo682a(Cursor cursor) {
        if (this.f3797p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo682a(cursor);
            if (cursor != null) {
                this.f3800s = cursor.getColumnIndex("suggest_text_1");
                this.f3801t = cursor.getColumnIndex("suggest_text_2");
                this.f3802u = cursor.getColumnIndex("suggest_text_2_url");
                this.f3803v = cursor.getColumnIndex("suggest_icon_1");
                this.f3804w = cursor.getColumnIndex("suggest_icon_2");
                this.f3805x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View mo684a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo684a(context, cursor, viewGroup);
        a.setTag(new C0980a(a));
        ((ImageView) a.findViewById(C0836f.edit_query)).setImageResource(this.f3796o);
        return a;
    }

    public void mo1048a(View view, Context context, Cursor cursor) {
        C0980a c0980a = (C0980a) view.getTag();
        int i;
        if (this.f3805x != -1) {
            i = cursor.getInt(this.f3805x);
        } else {
            i = 0;
        }
        if (c0980a.f3786a != null) {
            m7036a(c0980a.f3786a, m7033a(cursor, this.f3800s));
        }
        if (c0980a.f3787b != null) {
            CharSequence a = m7033a(cursor, this.f3802u);
            if (a != null) {
                a = m7041b(a);
            } else {
                a = m7033a(cursor, this.f3801t);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0980a.f3786a != null) {
                    c0980a.f3786a.setSingleLine(false);
                    c0980a.f3786a.setMaxLines(2);
                }
            } else if (c0980a.f3786a != null) {
                c0980a.f3786a.setSingleLine(true);
                c0980a.f3786a.setMaxLines(1);
            }
            m7036a(c0980a.f3787b, a);
        }
        if (c0980a.f3788c != null) {
            m7035a(c0980a.f3788c, m7043e(cursor), 4);
        }
        if (c0980a.f3789d != null) {
            m7035a(c0980a.f3789d, m7044f(cursor), 8);
        }
        if (this.f3798q == 2 || (this.f3798q == 1 && (r1 & 1) != 0)) {
            c0980a.f3790e.setVisibility(0);
            c0980a.f3790e.setTag(c0980a.f3786a.getText());
            c0980a.f3790e.setOnClickListener(this);
            return;
        }
        c0980a.f3790e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f3792k.m6477a((CharSequence) tag);
        }
    }

    private CharSequence m7041b(CharSequence charSequence) {
        if (this.f3799r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0831a.textColorSearchUrl, typedValue, true);
            this.f3799r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f3799r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m7036a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m7043e(Cursor cursor) {
        if (this.f3803v == -1) {
            return null;
        }
        Drawable a = m7032a(cursor.getString(this.f3803v));
        return a == null ? m7045g(cursor) : a;
    }

    private Drawable m7044f(Cursor cursor) {
        if (this.f3804w == -1) {
            return null;
        }
        return m7032a(cursor.getString(this.f3804w));
    }

    private void m7035a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence mo683c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m7034a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f3793l.shouldRewriteQueryFromData()) {
            a = m7034a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f3793l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m7034a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo684a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0980a) a.getTag()).f3786a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m7032a(String str) {
        Drawable b;
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f3794m.getPackageName() + "/" + parseInt;
            b = m7040b(str2);
            if (b != null) {
                return b;
            }
            b = C0307a.m2325a(this.f3794m, parseInt);
            m7037a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m7040b(str);
            if (b != null) {
                return b;
            }
            b = m7039b(Uri.parse(str));
            m7037a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m7039b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m7048a(uri);
            }
            openInputStream = this.f3794m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m7040b(String str) {
        ConstantState constantState = (ConstantState) this.f3795n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m7037a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f3795n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m7045g(Cursor cursor) {
        Drawable a = m7031a(this.f3793l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m7031a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f3795n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f3795n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f3794m.getResources());
        } else {
            Drawable b = m7038b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f3795n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m7038b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m7034a(Cursor cursor, String str) {
        return m7033a(cursor, cursor.getColumnIndex(str));
    }

    private static String m7033a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m7048a(Uri uri) throws FileNotFoundException {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m7046a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
