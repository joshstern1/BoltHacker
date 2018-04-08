package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

public class MaterialProgressBar extends ProgressBar {
    public static final int PROGRESS_STYLE_CIRCULAR = 0;
    public static final int PROGRESS_STYLE_HORIZONTAL = 1;
    private static final String TAG = MaterialProgressBar.class.getSimpleName();
    private int mProgressStyle;
    private TintInfo mProgressTint = new TintInfo();

    private static class TintInfo {
        boolean mHasTintList;
        boolean mHasTintMode;
        ColorStateList mTintList;
        Mode mTintMode;

        private TintInfo() {
        }
    }

    public MaterialProgressBar(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3080R.styleable.MaterialProgressBar, i, i2);
        this.mProgressStyle = obtainStyledAttributes.getInt(C3080R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(C3080R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
        boolean z3 = obtainStyledAttributes.getBoolean(C3080R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
        int i3 = C3080R.styleable.MaterialProgressBar_mpb_showTrack;
        if (this.mProgressStyle == 1) {
            z = true;
        }
        z = obtainStyledAttributes.getBoolean(i3, z);
        if (obtainStyledAttributes.hasValue(C3080R.styleable.MaterialProgressBar_android_tint)) {
            this.mProgressTint.mTintList = obtainStyledAttributes.getColorStateList(C3080R.styleable.MaterialProgressBar_android_tint);
            this.mProgressTint.mHasTintList = true;
        }
        if (obtainStyledAttributes.hasValue(C3080R.styleable.MaterialProgressBar_mpb_tintMode)) {
            this.mProgressTint.mTintMode = DrawableCompat.parseTintMode(obtainStyledAttributes.getInt(C3080R.styleable.MaterialProgressBar_mpb_tintMode, -1), null);
            this.mProgressTint.mHasTintMode = true;
        }
        obtainStyledAttributes.recycle();
        switch (this.mProgressStyle) {
            case 0:
                if (isIndeterminate() && !z2) {
                    setIndeterminateDrawable(new IndeterminateProgressDrawable(context));
                    break;
                }
                throw new UnsupportedOperationException("Determinate circular drawable is not yet supported");
                break;
            case 1:
                if (isIndeterminate() || z2) {
                    setIndeterminateDrawable(new IndeterminateHorizontalProgressDrawable(context));
                }
                if (!isIndeterminate() || z2) {
                    setProgressDrawable(new HorizontalProgressDrawable(context));
                    break;
                }
            default:
                throw new IllegalArgumentException("Unknown progress style: " + this.mProgressStyle);
        }
        setUseIntrinsicPadding(z3);
        setShowTrack(z);
    }

    public int getProgressStyle() {
        return this.mProgressStyle;
    }

    public Drawable getDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public boolean getUseIntrinsicPadding() {
        Drawable drawable = getDrawable();
        if (drawable instanceof IntrinsicPaddingDrawable) {
            return ((IntrinsicPaddingDrawable) drawable).getUseIntrinsicPadding();
        }
        throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
    }

    public void setUseIntrinsicPadding(boolean z) {
        Drawable drawable = getDrawable();
        if (drawable instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable) drawable).setUseIntrinsicPadding(z);
            return;
        }
        throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
    }

    public boolean getShowTrack() {
        Drawable drawable = getDrawable();
        if (drawable instanceof ShowTrackDrawable) {
            return ((ShowTrackDrawable) drawable).getShowTrack();
        }
        return false;
    }

    public void setShowTrack(boolean z) {
        Drawable drawable = getDrawable();
        if (drawable instanceof ShowTrackDrawable) {
            ((ShowTrackDrawable) drawable).setShowTrack(z);
        } else if (z) {
            throw new IllegalStateException("Drawable does not implement ShowTrackDrawable");
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
        if (this.mProgressTint != null) {
            applyDeterminateProgressTint();
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (this.mProgressTint != null) {
            applyIndeterminateProgressTint();
        }
    }

    public ColorStateList getProgressTintList() {
        return this.mProgressTint.mTintList;
    }

    public void setProgressTintList(ColorStateList colorStateList) {
        this.mProgressTint.mTintList = colorStateList;
        this.mProgressTint.mHasTintList = true;
        applyProgressTint();
    }

    public Mode getProgressTintMode() {
        return this.mProgressTint.mTintMode;
    }

    public void setProgressTintMode(Mode mode) {
        this.mProgressTint.mTintMode = mode;
        this.mProgressTint.mHasTintMode = true;
        applyProgressTint();
    }

    private void applyProgressTint() {
        applyDeterminateProgressTint();
        applyIndeterminateProgressTint();
    }

    private void applyDeterminateProgressTint() {
        if (this.mProgressTint.mHasTintList || this.mProgressTint.mHasTintMode) {
            Drawable progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                applyTintForDrawable(progressDrawable, this.mProgressTint);
            }
        }
    }

    private void applyIndeterminateProgressTint() {
        if (this.mProgressTint.mHasTintList || this.mProgressTint.mHasTintMode) {
            Drawable indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable != null) {
                applyTintForDrawable(indeterminateDrawable, this.mProgressTint);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void applyTintForDrawable(Drawable drawable, TintInfo tintInfo) {
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            if (tintInfo.mHasTintList) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintList(tintInfo.mTintList);
                } else {
                    Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    if (VERSION.SDK_INT >= 21) {
                        drawable.setTintList(tintInfo.mTintList);
                    }
                }
            }
            if (tintInfo.mHasTintMode) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintMode(tintInfo.mTintMode);
                } else {
                    Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    if (VERSION.SDK_INT >= 21) {
                        drawable.setTintMode(tintInfo.mTintMode);
                    }
                }
            }
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }
}
