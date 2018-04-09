package android.support.p011a.p012a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.p024g.C0495a;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class C0167b extends C0166g implements Animatable {
    private C0163a f788b;
    private Context f789c;
    private ArgbEvaluator f790d;
    private final Callback f791e;

    private static class C0163a extends ConstantState {
        int f782a;
        C0181h f783b;
        ArrayList<Animator> f784c;
        C0495a<Animator, String> f785d;

        public C0163a(Context context, C0163a c0163a, Callback callback, Resources resources) {
            int i = 0;
            if (c0163a != null) {
                this.f782a = c0163a.f782a;
                if (c0163a.f783b != null) {
                    ConstantState constantState = c0163a.f783b.getConstantState();
                    if (resources != null) {
                        this.f783b = (C0181h) constantState.newDrawable(resources);
                    } else {
                        this.f783b = (C0181h) constantState.newDrawable();
                    }
                    this.f783b = (C0181h) this.f783b.mutate();
                    this.f783b.setCallback(callback);
                    this.f783b.setBounds(c0163a.f783b.getBounds());
                    this.f783b.m1108a(false);
                }
                if (c0163a.f784c != null) {
                    int size = c0163a.f784c.size();
                    this.f784c = new ArrayList(size);
                    this.f785d = new C0495a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0163a.f784c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0163a.f785d.get(animator);
                        clone.setTarget(this.f783b.m1107a(str));
                        this.f784c.add(clone);
                        this.f785d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public int getChangingConfigurations() {
            return this.f782a;
        }
    }

    private static class C0164b extends ConstantState {
        private final ConstantState f786a;

        public C0164b(ConstantState constantState) {
            this.f786a = constantState;
        }

        public Drawable newDrawable() {
            C0167b c0167b = new C0167b();
            c0167b.a = this.f786a.newDrawable();
            c0167b.a.setCallback(c0167b.f791e);
            return c0167b;
        }

        public Drawable newDrawable(Resources resources) {
            C0167b c0167b = new C0167b();
            c0167b.a = this.f786a.newDrawable(resources);
            c0167b.a.setCallback(c0167b.f791e);
            return c0167b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C0167b c0167b = new C0167b();
            c0167b.a = this.f786a.newDrawable(resources, theme);
            c0167b.a.setCallback(c0167b.f791e);
            return c0167b;
        }

        public boolean canApplyTheme() {
            return this.f786a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f786a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private C0167b() {
        this(null, null, null);
    }

    private C0167b(Context context) {
        this(context, null, null);
    }

    private C0167b(Context context, C0163a c0163a, Resources resources) {
        this.f790d = null;
        this.f791e = new C0168c(this);
        this.f789c = context;
        if (c0163a != null) {
            this.f788b = c0163a;
        } else {
            this.f788b = new C0163a(context, c0163a, this.f791e, resources);
        }
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static C0167b m1038a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C0167b c0167b = new C0167b(context);
        c0167b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0167b;
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0164b(this.a.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f788b.f782a;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f788b.f783b.draw(canvas);
        if (m1041a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f788b.f783b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return this.f788b.f783b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return this.f788b.f783b.setLevel(i);
    }

    public int getAlpha() {
        if (this.a != null) {
            return C0441a.m2999c(this.a);
        }
        return this.f788b.f783b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f788b.f783b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f788b.f783b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0441a.m2990a(this.a, i);
        } else {
            this.f788b.f783b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0441a.m2992a(this.a, colorStateList);
        } else {
            this.f788b.f783b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0441a.m2995a(this.a, mode);
        } else {
            this.f788b.f783b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f788b.f783b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.f788b.f783b.isStateful();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.f788b.f783b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.f788b.f783b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.f788b.f783b.getIntrinsicHeight();
    }

    static TypedArray m1036a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            C0441a.m2994a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0167b.m1036a(resources, theme, attributeSet, C0162a.f780e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0181h a2 = C0181h.m1100a(resources, resourceId, theme);
                        a2.m1108a(false);
                        a2.setCallback(this.f791e);
                        if (this.f788b.f783b != null) {
                            this.f788b.f783b.setCallback(null);
                        }
                        this.f788b.f783b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0162a.f781f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f789c != null) {
                            m1040a(string, AnimatorInflater.loadAnimator(this.f789c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            C0441a.m2993a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return C0441a.m3000d(this.a);
        }
        return false;
    }

    private void m1039a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m1039a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f790d == null) {
                    this.f790d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f790d);
            }
        }
    }

    private void m1040a(String str, Animator animator) {
        animator.setTarget(this.f788b.f783b.m1107a(str));
        if (VERSION.SDK_INT < 21) {
            m1039a(animator);
        }
        if (this.f788b.f784c == null) {
            this.f788b.f784c = new ArrayList();
            this.f788b.f785d = new C0495a();
        }
        this.f788b.f784c.add(animator);
        this.f788b.f785d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f788b.f784c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean m1041a() {
        ArrayList arrayList = this.f788b.f784c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m1041a()) {
            ArrayList arrayList = this.f788b.f784c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f788b.f784c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
