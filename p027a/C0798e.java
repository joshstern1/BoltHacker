package android.support.v7.p027a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ao;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0841k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import no.nordicsemi.android.dfu.DfuBaseService;

class C0798e {
    private TextView f2626A;
    private TextView f2627B;
    private View f2628C;
    private ListAdapter f2629D;
    private int f2630E = -1;
    private int f2631F;
    private int f2632G;
    private int f2633H;
    private int f2634I;
    private int f2635J;
    private int f2636K;
    private int f2637L = 0;
    private Handler f2638M;
    private final OnClickListener f2639N = new C0799f(this);
    private final Context f2640a;
    private final ah f2641b;
    private final Window f2642c;
    private CharSequence f2643d;
    private CharSequence f2644e;
    private ListView f2645f;
    private View f2646g;
    private int f2647h;
    private int f2648i;
    private int f2649j;
    private int f2650k;
    private int f2651l;
    private boolean f2652m = false;
    private Button f2653n;
    private CharSequence f2654o;
    private Message f2655p;
    private Button f2656q;
    private CharSequence f2657r;
    private Message f2658s;
    private Button f2659t;
    private CharSequence f2660u;
    private Message f2661v;
    private NestedScrollView f2662w;
    private int f2663x = 0;
    private Drawable f2664y;
    private ImageView f2665z;

    public static class C0795a {
        public int f2586A;
        public boolean f2587B = false;
        public boolean[] f2588C;
        public boolean f2589D;
        public boolean f2590E;
        public int f2591F = -1;
        public OnMultiChoiceClickListener f2592G;
        public Cursor f2593H;
        public String f2594I;
        public String f2595J;
        public OnItemSelectedListener f2596K;
        public C0794a f2597L;
        public boolean f2598M = true;
        public final Context f2599a;
        public final LayoutInflater f2600b;
        public int f2601c = 0;
        public Drawable f2602d;
        public int f2603e = 0;
        public CharSequence f2604f;
        public View f2605g;
        public CharSequence f2606h;
        public CharSequence f2607i;
        public DialogInterface.OnClickListener f2608j;
        public CharSequence f2609k;
        public DialogInterface.OnClickListener f2610l;
        public CharSequence f2611m;
        public DialogInterface.OnClickListener f2612n;
        public boolean f2613o;
        public OnCancelListener f2614p;
        public OnDismissListener f2615q;
        public OnKeyListener f2616r;
        public CharSequence[] f2617s;
        public ListAdapter f2618t;
        public DialogInterface.OnClickListener f2619u;
        public int f2620v;
        public View f2621w;
        public int f2622x;
        public int f2623y;
        public int f2624z;

        public interface C0794a {
            void m5228a(ListView listView);
        }

        public C0795a(Context context) {
            this.f2599a = context;
            this.f2613o = true;
            this.f2600b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void m5230a(C0798e c0798e) {
            if (this.f2605g != null) {
                c0798e.m5267b(this.f2605g);
            } else {
                if (this.f2604f != null) {
                    c0798e.m5264a(this.f2604f);
                }
                if (this.f2602d != null) {
                    c0798e.m5262a(this.f2602d);
                }
                if (this.f2601c != 0) {
                    c0798e.m5266b(this.f2601c);
                }
                if (this.f2603e != 0) {
                    c0798e.m5266b(c0798e.m5270c(this.f2603e));
                }
            }
            if (this.f2606h != null) {
                c0798e.m5268b(this.f2606h);
            }
            if (this.f2607i != null) {
                c0798e.m5261a(-1, this.f2607i, this.f2608j, null);
            }
            if (this.f2609k != null) {
                c0798e.m5261a(-2, this.f2609k, this.f2610l, null);
            }
            if (this.f2611m != null) {
                c0798e.m5261a(-3, this.f2611m, this.f2612n, null);
            }
            if (!(this.f2617s == null && this.f2593H == null && this.f2618t == null)) {
                m5229b(c0798e);
            }
            if (this.f2621w != null) {
                if (this.f2587B) {
                    c0798e.m5263a(this.f2621w, this.f2622x, this.f2623y, this.f2624z, this.f2586A);
                    return;
                }
                c0798e.m5271c(this.f2621w);
            } else if (this.f2620v != 0) {
                c0798e.m5260a(this.f2620v);
            }
        }

        private void m5229b(C0798e c0798e) {
            ListAdapter simpleCursorAdapter;
            ListView listView = (ListView) this.f2600b.inflate(c0798e.f2633H, null);
            if (!this.f2589D) {
                int m;
                if (this.f2590E) {
                    m = c0798e.f2635J;
                } else {
                    m = c0798e.f2636K;
                }
                if (this.f2593H != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(this.f2599a, m, this.f2593H, new String[]{this.f2594I}, new int[]{16908308});
                } else if (this.f2618t != null) {
                    simpleCursorAdapter = this.f2618t;
                } else {
                    simpleCursorAdapter = new C0797c(this.f2599a, m, 16908308, this.f2617s);
                }
            } else if (this.f2593H == null) {
                simpleCursorAdapter = new C0804k(this, this.f2599a, c0798e.f2634I, 16908308, this.f2617s, listView);
            } else {
                Object c0805l = new C0805l(this, this.f2599a, this.f2593H, false, listView, c0798e);
            }
            if (this.f2597L != null) {
                this.f2597L.m5228a(listView);
            }
            c0798e.f2629D = simpleCursorAdapter;
            c0798e.f2630E = this.f2591F;
            if (this.f2619u != null) {
                listView.setOnItemClickListener(new C0806m(this, c0798e));
            } else if (this.f2592G != null) {
                listView.setOnItemClickListener(new C0807n(this, listView, c0798e));
            }
            if (this.f2596K != null) {
                listView.setOnItemSelectedListener(this.f2596K);
            }
            if (this.f2590E) {
                listView.setChoiceMode(1);
            } else if (this.f2589D) {
                listView.setChoiceMode(2);
            }
            c0798e.f2645f = listView;
        }
    }

    private static final class C0796b extends Handler {
        private WeakReference<DialogInterface> f2625a;

        public C0796b(DialogInterface dialogInterface) {
            this.f2625a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DfuBaseService.PROGRESS_ENABLING_DFU_MODE /*-3*/:
                case DfuBaseService.PROGRESS_STARTING /*-2*/:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2625a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class C0797c extends ArrayAdapter<CharSequence> {
        public C0797c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    public C0798e(Context context, ah ahVar, Window window) {
        this.f2640a = context;
        this.f2641b = ahVar;
        this.f2642c = window;
        this.f2638M = new C0796b(ahVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0841k.AlertDialog, C0831a.alertDialogStyle, 0);
        this.f2631F = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_android_layout, 0);
        this.f2632G = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_buttonPanelSideLayout, 0);
        this.f2633H = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_listLayout, 0);
        this.f2634I = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_multiChoiceItemLayout, 0);
        this.f2635J = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_singleChoiceItemLayout, 0);
        this.f2636K = obtainStyledAttributes.getResourceId(C0841k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        ahVar.m5009a(1);
    }

    static boolean m5239a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0798e.m5239a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void m5259a() {
        this.f2641b.setContentView(m5240b());
        m5245c();
    }

    private int m5240b() {
        if (this.f2632G == 0) {
            return this.f2631F;
        }
        if (this.f2637L == 1) {
            return this.f2632G;
        }
        return this.f2631F;
    }

    public void m5264a(CharSequence charSequence) {
        this.f2643d = charSequence;
        if (this.f2626A != null) {
            this.f2626A.setText(charSequence);
        }
    }

    public void m5267b(View view) {
        this.f2628C = view;
    }

    public void m5268b(CharSequence charSequence) {
        this.f2644e = charSequence;
        if (this.f2627B != null) {
            this.f2627B.setText(charSequence);
        }
    }

    public void m5260a(int i) {
        this.f2646g = null;
        this.f2647h = i;
        this.f2652m = false;
    }

    public void m5271c(View view) {
        this.f2646g = view;
        this.f2647h = 0;
        this.f2652m = false;
    }

    public void m5263a(View view, int i, int i2, int i3, int i4) {
        this.f2646g = view;
        this.f2647h = 0;
        this.f2652m = true;
        this.f2648i = i;
        this.f2649j = i2;
        this.f2650k = i3;
        this.f2651l = i4;
    }

    public void m5261a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f2638M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case DfuBaseService.PROGRESS_ENABLING_DFU_MODE /*-3*/:
                this.f2660u = charSequence;
                this.f2661v = message;
                return;
            case DfuBaseService.PROGRESS_STARTING /*-2*/:
                this.f2657r = charSequence;
                this.f2658s = message;
                return;
            case -1:
                this.f2654o = charSequence;
                this.f2655p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m5266b(int i) {
        this.f2664y = null;
        this.f2663x = i;
        if (this.f2665z == null) {
            return;
        }
        if (i != 0) {
            this.f2665z.setVisibility(0);
            this.f2665z.setImageResource(this.f2663x);
            return;
        }
        this.f2665z.setVisibility(8);
    }

    public void m5262a(Drawable drawable) {
        this.f2664y = drawable;
        this.f2663x = 0;
        if (this.f2665z == null) {
            return;
        }
        if (drawable != null) {
            this.f2665z.setVisibility(0);
            this.f2665z.setImageDrawable(drawable);
            return;
        }
        this.f2665z.setVisibility(8);
    }

    public int m5270c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f2640a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean m5265a(int i, KeyEvent keyEvent) {
        return this.f2662w != null && this.f2662w.m4538a(keyEvent);
    }

    public boolean m5269b(int i, KeyEvent keyEvent) {
        return this.f2662w != null && this.f2662w.m4538a(keyEvent);
    }

    private ViewGroup m5232a(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    private void m5245c() {
        boolean z;
        boolean z2;
        View findViewById = this.f2642c.findViewById(C0836f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0836f.topPanel);
        View findViewById3 = findViewById.findViewById(C0836f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0836f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0836f.customPanel);
        m5237a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0836f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0836f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0836f.buttonPanel);
        ViewGroup a = m5232a(findViewById5, findViewById2);
        ViewGroup a2 = m5232a(findViewById6, findViewById3);
        ViewGroup a3 = m5232a(findViewById7, findViewById4);
        m5246c(a2);
        m5248d(a3);
        m5243b(a);
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        if (a == null || a.getVisibility() == 8) {
            z = false;
        } else {
            z = true;
        }
        if (a3 == null || a3.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || a2 == null)) {
            findViewById3 = a2.findViewById(C0836f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z && this.f2662w != null) {
            this.f2662w.setClipToPadding(true);
        }
        if (!z3) {
            findViewById3 = this.f2645f != null ? this.f2645f : this.f2662w;
            if (findViewById3 != null) {
                int i;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m5238a(a2, findViewById3, (z2 ? 2 : 0) | i, 3);
            }
        }
        ListView listView = this.f2645f;
        if (listView != null && this.f2629D != null) {
            listView.setAdapter(this.f2629D);
            int i2 = this.f2630E;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    private void m5238a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f2642c.findViewById(C0836f.scrollIndicatorUp);
        View findViewById2 = this.f2642c.findViewById(C0836f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ao.m3904a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f2644e != null) {
                this.f2662w.setOnScrollChangeListener(new C0800g(this, findViewById, view2));
                this.f2662w.post(new C0801h(this, findViewById, view2));
            } else if (this.f2645f != null) {
                this.f2645f.setOnScrollListener(new C0802i(this, findViewById, view2));
                this.f2645f.post(new C0803j(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void m5237a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f2646g != null) {
            view = this.f2646g;
        } else if (this.f2647h != 0) {
            view = LayoutInflater.from(this.f2640a).inflate(this.f2647h, viewGroup, false);
        } else {
            view = null;
        }
        if (view != null) {
            z = true;
        }
        if (!(z && C0798e.m5239a(view))) {
            this.f2642c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f2642c.findViewById(C0836f.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.f2652m) {
                frameLayout.setPadding(this.f2648i, this.f2649j, this.f2650k, this.f2651l);
            }
            if (this.f2645f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m5243b(ViewGroup viewGroup) {
        if (this.f2628C != null) {
            viewGroup.addView(this.f2628C, 0, new LayoutParams(-1, -2));
            this.f2642c.findViewById(C0836f.title_template).setVisibility(8);
            return;
        }
        this.f2665z = (ImageView) this.f2642c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f2643d) ? 1 : 0) != 0) {
            this.f2626A = (TextView) this.f2642c.findViewById(C0836f.alertTitle);
            this.f2626A.setText(this.f2643d);
            if (this.f2663x != 0) {
                this.f2665z.setImageResource(this.f2663x);
                return;
            } else if (this.f2664y != null) {
                this.f2665z.setImageDrawable(this.f2664y);
                return;
            } else {
                this.f2626A.setPadding(this.f2665z.getPaddingLeft(), this.f2665z.getPaddingTop(), this.f2665z.getPaddingRight(), this.f2665z.getPaddingBottom());
                this.f2665z.setVisibility(8);
                return;
            }
        }
        this.f2642c.findViewById(C0836f.title_template).setVisibility(8);
        this.f2665z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m5246c(ViewGroup viewGroup) {
        this.f2662w = (NestedScrollView) this.f2642c.findViewById(C0836f.scrollView);
        this.f2662w.setFocusable(false);
        this.f2662w.setNestedScrollingEnabled(false);
        this.f2627B = (TextView) viewGroup.findViewById(16908299);
        if (this.f2627B != null) {
            if (this.f2644e != null) {
                this.f2627B.setText(this.f2644e);
                return;
            }
            this.f2627B.setVisibility(8);
            this.f2662w.removeView(this.f2627B);
            if (this.f2645f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f2662w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f2662w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f2645f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private static void m5242b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ao.m3923b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ao.m3923b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m5248d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f2653n = (Button) viewGroup.findViewById(16908313);
        this.f2653n.setOnClickListener(this.f2639N);
        if (TextUtils.isEmpty(this.f2654o)) {
            this.f2653n.setVisibility(8);
            i = 0;
        } else {
            this.f2653n.setText(this.f2654o);
            this.f2653n.setVisibility(0);
            i = 1;
        }
        this.f2656q = (Button) viewGroup.findViewById(16908314);
        this.f2656q.setOnClickListener(this.f2639N);
        if (TextUtils.isEmpty(this.f2657r)) {
            this.f2656q.setVisibility(8);
        } else {
            this.f2656q.setText(this.f2657r);
            this.f2656q.setVisibility(0);
            i |= 2;
        }
        this.f2659t = (Button) viewGroup.findViewById(16908315);
        this.f2659t.setOnClickListener(this.f2639N);
        if (TextUtils.isEmpty(this.f2660u)) {
            this.f2659t.setVisibility(8);
        } else {
            this.f2659t.setText(this.f2660u);
            this.f2659t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }
}
