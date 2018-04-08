package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class C0390p extends Fragment implements OnCancelListener, OnDismissListener {
    int f1802a = 0;
    int f1803b = 0;
    boolean f1804c = true;
    boolean f1805d = true;
    int f1806e = -1;
    Dialog f1807f;
    boolean f1808g;
    boolean f1809h;
    boolean f1810i;

    public void mo1535a(C0401x c0401x, String str) {
        this.f1809h = false;
        this.f1810i = true;
        ah a = c0401x.mo378a();
        a.mo342a((Fragment) this, str);
        a.mo343b();
    }

    public void m2694a() {
        m2699a(false);
    }

    void m2699a(boolean z) {
        if (!this.f1809h) {
            this.f1809h = true;
            this.f1810i = false;
            if (this.f1807f != null) {
                this.f1807f.dismiss();
                this.f1807f = null;
            }
            this.f1808g = true;
            if (this.f1806e >= 0) {
                m2311n().mo380a(this.f1806e, 1);
                this.f1806e = -1;
                return;
            }
            ah a = m2311n().mo378a();
            a.mo341a(this);
            if (z) {
                a.mo344c();
            } else {
                a.mo343b();
            }
        }
    }

    public Dialog m2700b() {
        return this.f1807f;
    }

    public int f_() {
        return this.f1803b;
    }

    public void m2702b(boolean z) {
        this.f1805d = z;
    }

    public boolean g_() {
        return this.f1805d;
    }

    public void mo348a(Context context) {
        super.mo348a(context);
        if (!this.f1810i) {
            this.f1809h = false;
        }
    }

    public void mo352e() {
        super.mo352e();
        if (!this.f1810i && !this.f1809h) {
            this.f1809h = true;
        }
    }

    public void mo349a(Bundle bundle) {
        super.mo349a(bundle);
        this.f1805d = this.H == 0;
        if (bundle != null) {
            this.f1802a = bundle.getInt("android:style", 0);
            this.f1803b = bundle.getInt("android:theme", 0);
            this.f1804c = bundle.getBoolean("android:cancelable", true);
            this.f1805d = bundle.getBoolean("android:showsDialog", this.f1805d);
            this.f1806e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater mo350b(Bundle bundle) {
        if (!this.f1805d) {
            return super.mo350b(bundle);
        }
        this.f1807f = mo1536c(bundle);
        if (this.f1807f == null) {
            return (LayoutInflater) this.C.m2732g().getSystemService("layout_inflater");
        }
        m2695a(this.f1807f, this.f1802a);
        return (LayoutInflater) this.f1807f.getContext().getSystemService("layout_inflater");
    }

    public void m2695a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog mo1536c(Bundle bundle) {
        return new Dialog(m2309l(), f_());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f1808g) {
            m2699a(true);
        }
    }

    public void mo351d(Bundle bundle) {
        super.mo351d(bundle);
        if (this.f1805d) {
            View t = m2317t();
            if (t != null) {
                if (t.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f1807f.setContentView(t);
            }
            Activity l = m2309l();
            if (l != null) {
                this.f1807f.setOwnerActivity(l);
            }
            this.f1807f.setCancelable(this.f1804c);
            this.f1807f.setOnCancelListener(this);
            this.f1807f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f1807f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void mo354f() {
        super.mo354f();
        if (this.f1807f != null) {
            this.f1808g = false;
            this.f1807f.show();
        }
    }

    public void mo353e(Bundle bundle) {
        super.mo353e(bundle);
        if (this.f1807f != null) {
            Bundle onSaveInstanceState = this.f1807f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f1802a != 0) {
            bundle.putInt("android:style", this.f1802a);
        }
        if (this.f1803b != 0) {
            bundle.putInt("android:theme", this.f1803b);
        }
        if (!this.f1804c) {
            bundle.putBoolean("android:cancelable", this.f1804c);
        }
        if (!this.f1805d) {
            bundle.putBoolean("android:showsDialog", this.f1805d);
        }
        if (this.f1806e != -1) {
            bundle.putInt("android:backStackId", this.f1806e);
        }
    }

    public void mo355g() {
        super.mo355g();
        if (this.f1807f != null) {
            this.f1807f.hide();
        }
    }

    public void mo356h() {
        super.mo356h();
        if (this.f1807f != null) {
            this.f1808g = true;
            this.f1807f.dismiss();
            this.f1807f = null;
        }
    }
}
