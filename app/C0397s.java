package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p024g.C0494j;
import android.support.v4.p024g.C0512k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0397s extends C0389o {
    final Handler f1826c = new C0398t(this);
    final C0399v f1827d = C0399v.m2762a(new C0395a(this));
    boolean f1828e;
    boolean f1829f;
    boolean f1830g;
    boolean f1831h;
    boolean f1832i;
    boolean f1833j;
    int f1834k;
    C0512k<String> f1835l;

    class C0395a extends C0394w<C0397s> {
        final /* synthetic */ C0397s f1822a;

        public C0395a(C0397s c0397s) {
            this.f1822a = c0397s;
            super(c0397s);
        }

        public void mo360a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f1822a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo361a(Fragment fragment) {
            return !this.f1822a.isFinishing();
        }

        public LayoutInflater mo362b() {
            return this.f1822a.getLayoutInflater().cloneInContext(this.f1822a);
        }

        public void mo364c() {
            this.f1822a.mo792d();
        }

        public void mo359a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f1822a.m2755a(fragment, intent, i, bundle);
        }

        public boolean mo365d() {
            return this.f1822a.getWindow() != null;
        }

        public int mo366e() {
            Window window = this.f1822a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void mo363b(Fragment fragment) {
            this.f1822a.m2754a(fragment);
        }

        public View mo357a(int i) {
            return this.f1822a.findViewById(i);
        }

        public boolean mo358a() {
            Window window = this.f1822a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    static final class C0396b {
        Object f1823a;
        ad f1824b;
        C0494j<String, ao> f1825c;

        C0396b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f1827d.m2775b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f1835l.m3169a(i4);
            this.f1835l.m3175c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f1827d.m2763a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.mo1459a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f1827d.m2764a().mo384c()) {
            b_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1827d.m2766a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f1827d.m2768a(null);
        super.onCreate(bundle);
        C0396b c0396b = (C0396b) getLastNonConfigurationInstance();
        if (c0396b != null) {
            this.f1827d.m2769a(c0396b.f1825c);
        }
        if (bundle != null) {
            this.f1827d.m2767a(bundle.getParcelable("android:support:fragments"), c0396b != null ? c0396b.f1824b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f1834k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f1835l = new C0512k(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f1835l.m3173b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f1835l == null) {
            this.f1835l = new C0512k();
            this.f1834k = 0;
        }
        this.f1827d.m2780e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f1827d.m2773a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View mo367a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1827d.m2765a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m2756a(false);
        this.f1827d.m2787l();
        this.f1827d.m2791p();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f1827d.m2788m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f1827d.m2774a(menuItem);
            case 6:
                return this.f1827d.m2777b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f1827d.m2776b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f1829f = false;
        if (this.f1826c.hasMessages(2)) {
            this.f1826c.removeMessages(2);
            a_();
        }
        this.f1827d.m2784i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1827d.m2775b();
    }

    public void onStateNotSaved() {
        this.f1827d.m2775b();
    }

    protected void onResume() {
        super.onResume();
        this.f1826c.sendEmptyMessage(2);
        this.f1829f = true;
        this.f1827d.m2789n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f1826c.removeMessages(2);
        a_();
        this.f1827d.m2789n();
    }

    protected void a_() {
        this.f1827d.m2783h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f1833j) {
            this.f1833j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m2757a(view, menu) | this.f1827d.m2772a(menu);
    }

    protected boolean m2757a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f1830g) {
            m2756a(true);
        }
        Object c = m2758c();
        ad d = this.f1827d.m2779d();
        C0494j r = this.f1827d.m2793r();
        if (d == null && r == null && c == null) {
            return null;
        }
        Object c0396b = new C0396b();
        c0396b.f1823a = c;
        c0396b.f1824b = d;
        c0396b.f1825c = r;
        return c0396b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable c = this.f1827d.m2778c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.f1835l.m3171b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f1834k);
            int[] iArr = new int[this.f1835l.m3171b()];
            String[] strArr = new String[this.f1835l.m3171b()];
            for (int i = 0; i < this.f1835l.m3171b(); i++) {
                iArr[i] = this.f1835l.m3176d(i);
                strArr[i] = (String) this.f1835l.m3177e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f1830g = false;
        this.f1831h = false;
        this.f1826c.removeMessages(1);
        if (!this.f1828e) {
            this.f1828e = true;
            this.f1827d.m2781f();
        }
        this.f1827d.m2775b();
        this.f1827d.m2789n();
        this.f1827d.m2790o();
        this.f1827d.m2782g();
        this.f1827d.m2792q();
    }

    protected void onStop() {
        super.onStop();
        this.f1830g = true;
        this.f1826c.sendEmptyMessage(1);
        this.f1827d.m2785j();
    }

    public Object m2758c() {
        return null;
    }

    public void mo792d() {
        if (VERSION.SDK_INT >= 11) {
            C0347b.m2560a(this);
        } else {
            this.f1833j = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f1828e);
            printWriter.print("mResumed=");
            printWriter.print(this.f1829f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f1830g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f1831h);
            this.f1827d.m2770a(str2, fileDescriptor, printWriter, strArr);
            this.f1827d.m2764a().mo382a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m2751a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f1828e);
            printWriter.print("mResumed=");
            printWriter.print(this.f1829f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f1830g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f1831h);
            this.f1827d.m2770a(str2, fileDescriptor, printWriter, strArr);
            this.f1827d.m2764a().mo382a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m2751a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m2750a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m2751a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0397s.m2750a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m2751a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m2756a(boolean z) {
        if (!this.f1831h) {
            this.f1831h = true;
            this.f1832i = z;
            this.f1826c.removeMessages(1);
            m2760e();
        } else if (z) {
            this.f1827d.m2790o();
            this.f1827d.m2771a(true);
        }
    }

    void m2760e() {
        this.f1827d.m2771a(this.f1832i);
        this.f1827d.m2786k();
    }

    public void m2754a(Fragment fragment) {
    }

    public C0401x m2761f() {
        return this.f1827d.m2764a();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            C0387m.m2693a(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f1835l.m3169a(i3);
            this.f1835l.m3175c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f1827d.m2763a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.m2264a(i & 65535, strArr, iArr);
            }
        }
    }

    public void m2755a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.b = true;
        if (i == -1) {
            try {
                C0308a.m2332a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            C0387m.m2693a(i);
            C0308a.m2332a(this, intent, ((m2752b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.b = false;
        }
    }

    private int m2752b(Fragment fragment) {
        if (this.f1835l.m3171b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f1835l.m3178f(this.f1834k) >= 0) {
            this.f1834k = (this.f1834k + 1) % 65534;
        }
        int i = this.f1834k;
        this.f1835l.m3173b(i, fragment.f1518q);
        this.f1834k = (this.f1834k + 1) % 65534;
        return i;
    }
}
