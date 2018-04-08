package com.codetroopers.betterpickers.radialtimepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.p025a.C0532c;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.codetroopers.betterpickers.C1282a;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.p059c.p060a.C1238a;
import com.p059c.p060a.C1250c;
import com.p059c.p060a.C1260k;
import com.p059c.p062c.C1281a;
import no.nordicsemi.android.dfu.DfuBaseService;

public class RadialPickerLayout extends FrameLayout implements OnTouchListener {
    private AccessibilityManager f4993A;
    private C1250c f4994B;
    private Handler f4995C = new Handler();
    private final int f4996a;
    private final int f4997b;
    private int f4998c;
    private C1282a f4999d;
    private C1328a f5000e;
    private boolean f5001f;
    private int f5002g;
    private int f5003h;
    private boolean f5004i;
    private boolean f5005j;
    private int f5006k;
    private C1330b f5007l;
    private C1329a f5008m;
    private C1337g f5009n;
    private C1337g f5010o;
    private C1334e f5011p;
    private C1334e f5012q;
    private View f5013r;
    private int[] f5014s;
    private boolean f5015t;
    private int f5016u = -1;
    private boolean f5017v;
    private boolean f5018w;
    private int f5019x;
    private float f5020y;
    private float f5021z;

    public interface C1328a {
        void mo1276a(int i, int i2, boolean z);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
        this.f4996a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4997b = ViewConfiguration.getTapTimeout();
        this.f5017v = false;
        this.f5007l = new C1330b(context);
        addView(this.f5007l);
        this.f5008m = new C1329a(context);
        addView(this.f5008m);
        this.f5009n = new C1337g(context);
        addView(this.f5009n);
        this.f5010o = new C1337g(context);
        addView(this.f5010o);
        this.f5011p = new C1334e(context);
        addView(this.f5011p);
        this.f5012q = new C1334e(context);
        addView(this.f5012q);
        m8700a();
        this.f4998c = -1;
        this.f5015t = true;
        this.f5013r = new View(context);
        this.f5013r.setLayoutParams(new LayoutParams(-1, -1));
        this.f5013r.setBackgroundColor(getResources().getColor(C1284a.bpTransparent_black));
        this.f5013r.setVisibility(4);
        addView(this.f5013r);
        this.f4993A = (AccessibilityManager) context.getSystemService("accessibility");
        this.f5001f = false;
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        size = Math.min(size, size2);
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, mode), MeasureSpec.makeMeasureSpec(size, mode2));
    }

    public void setOnValueSelectedListener(C1328a c1328a) {
        this.f5000e = c1328a;
    }

    public void m8712a(Context context, C1282a c1282a, int i, int i2, boolean z) {
        if (this.f5001f) {
            Log.e("RadialPickerLayout", "Time has already been initialized.");
            return;
        }
        this.f4999d = c1282a;
        this.f5004i = z;
        this.f5005j = C0532c.m3254a(this.f4993A) ? true : this.f5004i;
        this.f5007l.m8716a(context, this.f5005j);
        this.f5007l.invalidate();
        if (!this.f5005j) {
            this.f5008m.m8715a(context, i < 12 ? 0 : 1);
            this.f5008m.invalidate();
        }
        Resources resources = context.getResources();
        int[] iArr = new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] iArr2 = new int[]{0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] iArr3 = new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        String[] strArr = new String[12];
        String[] strArr2 = new String[12];
        String[] strArr3 = new String[12];
        for (int i3 = 0; i3 < 12; i3++) {
            strArr[i3] = z ? String.format("%02d", new Object[]{Integer.valueOf(iArr2[i3])}) : String.format("%d", new Object[]{Integer.valueOf(iArr[i3])});
            strArr2[i3] = String.format("%d", new Object[]{Integer.valueOf(iArr[i3])});
            strArr3[i3] = String.format("%02d", new Object[]{Integer.valueOf(iArr3[i3])});
        }
        C1337g c1337g = this.f5009n;
        if (!z) {
            strArr2 = null;
        }
        c1337g.m8725a(resources, strArr, strArr2, this.f5005j, true);
        this.f5009n.invalidate();
        this.f5010o.m8725a(resources, strArr3, null, this.f5005j, false);
        this.f5010o.invalidate();
        m8707c(0, i);
        m8707c(1, i2);
        this.f5011p.m8720a(context, this.f5005j, z, true, (i % 12) * 30, m8701a(i));
        this.f5012q.m8720a(context, this.f5005j, false, false, i2 * 6, false);
        this.f5001f = true;
    }

    void setTheme(TypedArray typedArray) {
        this.f5007l.setTheme(typedArray);
        this.f5008m.setTheme(typedArray);
        this.f5009n.setTheme(typedArray);
        this.f5010o.setTheme(typedArray);
        this.f5011p.setTheme(typedArray);
        this.f5012q.setTheme(typedArray);
    }

    public void m8710a(int i, int i2) {
        m8705b(0, i);
        m8705b(1, i2);
    }

    private void m8705b(int i, int i2) {
        if (i == 0) {
            m8707c(0, i2);
            this.f5011p.m8719a((i2 % 12) * 30, m8701a(i2), false);
            this.f5011p.invalidate();
        } else if (i == 1) {
            m8707c(1, i2);
            this.f5012q.m8719a(i2 * 6, false, false);
            this.f5012q.invalidate();
        }
    }

    private boolean m8701a(int i) {
        return this.f5004i && i <= 12 && i != 0;
    }

    public int getHours() {
        return this.f5002g;
    }

    public int getMinutes() {
        return this.f5003h;
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.f5002g;
        }
        if (currentItemShowing == 1) {
            return this.f5003h;
        }
        return -1;
    }

    public int getIsCurrentlyAmOrPm() {
        if (this.f5002g < 12) {
            return 0;
        }
        if (this.f5002g < 24) {
            return 1;
        }
        return -1;
    }

    private void m8707c(int i, int i2) {
        if (i == 0) {
            this.f5002g = i2;
        } else if (i == 1) {
            this.f5003h = i2;
        } else if (i != 2) {
        } else {
            if (i2 == 0) {
                this.f5002g %= 12;
            } else if (i2 == 1) {
                this.f5002g = (this.f5002g % 12) + 12;
            }
        }
    }

    public void setAmOrPm(int i) {
        this.f5008m.setAmOrPm(i);
        this.f5008m.invalidate();
        m8707c(2, i);
    }

    private void m8700a() {
        this.f5014s = new int[361];
        int i = 0;
        int i2 = 8;
        int i3 = 1;
        for (int i4 = 0; i4 < 361; i4++) {
            this.f5014s[i4] = i;
            if (i3 == i2) {
                i3 = i + 6;
                if (i3 == 360) {
                    i2 = 7;
                } else if (i3 % 30 == 0) {
                    i2 = 14;
                } else {
                    i2 = 4;
                }
                i = i3;
                i3 = 1;
            } else {
                i3++;
            }
        }
    }

    private int m8703b(int i) {
        if (this.f5014s == null) {
            return -1;
        }
        return this.f5014s[i];
    }

    private int m8708d(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        if (i2 == 1) {
            return i4;
        }
        if (i2 == -1) {
            if (i == i3) {
                return i3 - 30;
            }
            return i3;
        } else if (i - i3 >= i4 - i) {
            return i4;
        } else {
            return i3;
        }
    }

    private int m8696a(int i, boolean z, boolean z2, boolean z3) {
        if (i == -1) {
            return -1;
        }
        int b;
        C1334e c1334e;
        int i2;
        int currentItemShowing = getCurrentItemShowing();
        int i3 = (z2 || currentItemShowing != 1) ? 0 : 1;
        if (i3 != 0) {
            b = m8703b(i);
        } else {
            b = m8708d(i, 0);
        }
        if (currentItemShowing == 0) {
            c1334e = this.f5011p;
            i2 = 30;
        } else {
            c1334e = this.f5012q;
            i2 = 6;
        }
        c1334e.m8719a(b, z, z3);
        c1334e.invalidate();
        if (currentItemShowing != 0) {
            if (b == 360 && currentItemShowing == 1) {
                i3 = 0;
            }
            i3 = b;
        } else if (!this.f5004i) {
            if (b == 0) {
                i3 = 360;
            }
            i3 = b;
        } else if (b == 0 && z) {
            i3 = 360;
        } else {
            if (b == 360 && !z) {
                i3 = 0;
            }
            i3 = b;
        }
        i2 = i3 / i2;
        if (currentItemShowing != 0 || !this.f5004i || z || i3 == 0) {
            return i2;
        }
        return i2 + 12;
    }

    private int m8695a(float f, float f2, boolean z, Boolean[] boolArr) {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.f5011p.m8718a(f, f2, z, boolArr);
        }
        if (currentItemShowing == 1) {
            return this.f5012q.m8718a(f, f2, z, boolArr);
        }
        return -1;
    }

    public int getCurrentItemShowing() {
        if (this.f5006k == 0 || this.f5006k == 1) {
            return this.f5006k;
        }
        Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + this.f5006k);
        return -1;
    }

    public void m8711a(int i, boolean z) {
        int i2 = 255;
        if (i == 0 || i == 1) {
            int currentItemShowing = getCurrentItemShowing();
            this.f5006k = i;
            if (!z || i == currentItemShowing) {
                currentItemShowing = i == 0 ? 255 : 0;
                if (i != 1) {
                    i2 = 0;
                }
                C1281a.m8493a(this.f5009n, (float) currentItemShowing);
                C1281a.m8493a(this.f5011p, (float) currentItemShowing);
                C1281a.m8493a(this.f5010o, (float) i2);
                C1281a.m8493a(this.f5012q, (float) i2);
                return;
            }
            C1238a[] c1238aArr = new C1260k[4];
            if (i == 1) {
                c1238aArr[0] = this.f5009n.getDisappearAnimator();
                c1238aArr[1] = this.f5011p.getDisappearAnimator();
                c1238aArr[2] = this.f5010o.getReappearAnimator();
                c1238aArr[3] = this.f5012q.getReappearAnimator();
            } else if (i == 0) {
                c1238aArr[0] = this.f5009n.getReappearAnimator();
                c1238aArr[1] = this.f5011p.getReappearAnimator();
                c1238aArr[2] = this.f5010o.getDisappearAnimator();
                c1238aArr[3] = this.f5012q.getDisappearAnimator();
            }
            if (this.f4994B != null && this.f4994B.mo1223d()) {
                this.f4994B.mo1221c();
            }
            this.f4994B = new C1250c();
            this.f4994B.m8337a(c1238aArr);
            this.f4994B.mo1219a();
            return;
        }
        Log.e("RadialPickerLayout", "TimePicker does not support view at index " + i);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Boolean[] boolArr = new Boolean[]{Boolean.valueOf(false)};
        int a;
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.f5015t) {
                    return true;
                }
                this.f5020y = x;
                this.f5021z = y;
                this.f4998c = -1;
                this.f5017v = false;
                this.f5018w = true;
                if (this.f5005j) {
                    this.f5016u = -1;
                } else {
                    this.f5016u = this.f5008m.m8714a(x, y);
                }
                if (this.f5016u == 0 || this.f5016u == 1) {
                    this.f4999d.m8501c();
                    this.f5019x = -1;
                    this.f4995C.postDelayed(new C1331c(this), (long) this.f4997b);
                    return true;
                }
                this.f5019x = m8695a(x, y, C0532c.m3254a(this.f4993A), boolArr);
                if (this.f5019x == -1) {
                    return true;
                }
                this.f4999d.m8501c();
                this.f4995C.postDelayed(new C1332d(this, boolArr), (long) this.f4997b);
                return true;
            case 1:
                if (this.f5015t) {
                    this.f4995C.removeCallbacksAndMessages(null);
                    this.f5018w = false;
                    if (this.f5016u == 0 || this.f5016u == 1) {
                        a = this.f5008m.m8714a(x, y);
                        this.f5008m.setAmOrPmPressed(-1);
                        this.f5008m.invalidate();
                        if (a == this.f5016u) {
                            this.f5008m.setAmOrPm(a);
                            if (getIsCurrentlyAmOrPm() != a) {
                                this.f5000e.mo1276a(2, this.f5016u, false);
                                m8707c(2, a);
                            }
                        }
                        this.f5016u = -1;
                        break;
                    }
                    if (this.f5019x != -1) {
                        int a2 = m8695a(x, y, this.f5017v, boolArr);
                        if (a2 != -1) {
                            a = m8696a(a2, boolArr[0].booleanValue(), !this.f5017v, false);
                            if (getCurrentItemShowing() == 0 && !this.f5004i) {
                                a2 = getIsCurrentlyAmOrPm();
                                if (a2 == 0 && a == 12) {
                                    a = 0;
                                } else if (a2 == 1 && a != 12) {
                                    a += 12;
                                }
                            }
                            m8707c(getCurrentItemShowing(), a);
                            this.f5000e.mo1276a(getCurrentItemShowing(), a, true);
                        }
                    }
                    this.f5017v = false;
                    return true;
                }
                Log.d("RadialPickerLayout", "Input was disabled, but received ACTION_UP.");
                this.f5000e.mo1276a(3, 1, false);
                return true;
            case 2:
                if (this.f5015t) {
                    float abs = Math.abs(y - this.f5021z);
                    float abs2 = Math.abs(x - this.f5020y);
                    if (this.f5017v || abs2 > ((float) this.f4996a) || abs > ((float) this.f4996a)) {
                        if (this.f5016u == 0 || this.f5016u == 1) {
                            this.f4995C.removeCallbacksAndMessages(null);
                            if (this.f5008m.m8714a(x, y) != this.f5016u) {
                                this.f5008m.setAmOrPmPressed(-1);
                                this.f5008m.invalidate();
                                this.f5016u = -1;
                                break;
                            }
                        } else if (this.f5019x != -1) {
                            this.f5017v = true;
                            this.f4995C.removeCallbacksAndMessages(null);
                            a = m8695a(x, y, true, boolArr);
                            if (a == -1) {
                                return true;
                            }
                            a = m8696a(a, boolArr[0].booleanValue(), false, true);
                            if (a == this.f4998c) {
                                return true;
                            }
                            this.f4999d.m8501c();
                            this.f4998c = a;
                            this.f5000e.mo1276a(getCurrentItemShowing(), a, false);
                            return true;
                        }
                    }
                }
                Log.e("RadialPickerLayout", "Input was disabled, but received ACTION_MOVE.");
                return true;
                break;
        }
        return false;
    }

    public boolean m8713a(boolean z) {
        int i = 0;
        if (this.f5018w && !z) {
            return false;
        }
        this.f5015t = z;
        View view = this.f5013r;
        if (z) {
            i = 4;
        }
        view.setVisibility(i);
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(DfuBaseService.ERROR_REMOTE_MASK);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int i;
        accessibilityEvent.getText().clear();
        Time time = new Time();
        time.hour = getHours();
        time.minute = getMinutes();
        long normalize = time.normalize(true);
        if (this.f5004i) {
            i = 129;
        } else {
            i = 1;
        }
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), normalize, i));
        return true;
    }

    @SuppressLint({"NewApi"})
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        int i2;
        if (i == 4096) {
            i2 = 1;
        } else if (i == DfuBaseService.ERROR_REMOTE_MASK) {
            i2 = -1;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return false;
        }
        int i3;
        int currentlyShowingValue = getCurrentlyShowingValue();
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            i3 = 30;
            currentlyShowingValue %= 12;
        } else if (currentItemShowing == 1) {
            i3 = 6;
        } else {
            i3 = 0;
        }
        i2 = m8708d(currentlyShowingValue * i3, i2) / i3;
        if (currentItemShowing != 0) {
            currentlyShowingValue = 55;
            i3 = 0;
        } else if (this.f5004i) {
            currentlyShowingValue = 23;
            i3 = 0;
        } else {
            currentlyShowingValue = 12;
            i3 = 1;
        }
        if (i2 <= currentlyShowingValue) {
            if (i2 < i3) {
                i3 = currentlyShowingValue;
            } else {
                i3 = i2;
            }
        }
        m8705b(currentItemShowing, i3);
        this.f5000e.mo1276a(currentItemShowing, i3, false);
        return true;
    }
}
