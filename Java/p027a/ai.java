package android.support.v7.p027a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p024g.C0495a;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0853d;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.C0943s;
import android.support.v7.widget.C1005u;
import android.support.v7.widget.C1013y;
import android.support.v7.widget.aa;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.support.v7.widget.db;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class ai {
    private static final Class<?>[] f2467a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f2468b = new int[]{16843375};
    private static final String[] f2469c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f2470d = new C0495a();
    private final Object[] f2471e = new Object[2];

    private static class C0764a implements OnClickListener {
        private final View f2463a;
        private final String f2464b;
        private Method f2465c;
        private Context f2466d;

        public C0764a(View view, String str) {
            this.f2463a = view;
            this.f2464b = str;
        }

        public void onClick(View view) {
            if (this.f2465c == null) {
                m5011a(this.f2463a.getContext(), this.f2464b);
            }
            try {
                this.f2465c.invoke(this.f2466d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void m5011a(Context context, String str) {
            String str2;
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f2464b, new Class[]{View.class});
                        if (method != null) {
                            this.f2465c = method;
                            this.f2466d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.f2463a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f2463a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f2464b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f2463a.getClass() + str2);
        }
    }

    ai() {
    }

    public final View m5016a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = ai.m5012a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = db.m7061a(context2);
        }
        View view3 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view3 = new AppCompatTextView(context2, attributeSet);
                break;
            case 1:
                view3 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view3 = new AppCompatButton(context2, attributeSet);
                break;
            case 3:
                view3 = new AppCompatEditText(context2, attributeSet);
                break;
            case 4:
                view3 = new AppCompatSpinner(context2, attributeSet);
                break;
            case 5:
                view3 = new C1013y(context2, attributeSet);
                break;
            case 6:
                view3 = new AppCompatCheckBox(context2, attributeSet);
                break;
            case 7:
                view3 = new AppCompatRadioButton(context2, attributeSet);
                break;
            case 8:
                view3 = new C1005u(context2, attributeSet);
                break;
            case 9:
                view3 = new C0943s(context2, attributeSet);
                break;
            case 10:
                view3 = new aa(context2, attributeSet);
                break;
            case 11:
                view3 = new ae(context2, attributeSet);
                break;
            case 12:
                view3 = new af(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m5013a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m5015a(view2, attributeSet);
        }
        return view2;
    }

    private View m5013a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f2471e[0] = context;
            this.f2471e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f2469c) {
                    a = m5014a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f2471e[0] = null;
                this.f2471e[1] = null;
                return null;
            }
            a = m5014a(context, str, null);
            this.f2471e[0] = null;
            this.f2471e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f2471e[0] = null;
            this.f2471e[1] = null;
        }
    }

    private void m5015a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ao.m3898J(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2468b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0764a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View m5014a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) f2470d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f2467a);
                f2470d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2471e);
    }

    private static Context m5012a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(C0841k.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0841k.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof C0853d) && ((C0853d) context).m5489a() == i) {
            return context;
        }
        return new C0853d(context, i);
    }
}
