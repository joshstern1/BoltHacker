package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class cb extends Resources {
    private final Resources f3739a;

    public cb(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3739a = resources;
    }

    public CharSequence getText(int i) throws NotFoundException {
        return this.f3739a.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) throws NotFoundException {
        return this.f3739a.getQuantityText(i, i2);
    }

    public String getString(int i) throws NotFoundException {
        return this.f3739a.getString(i);
    }

    public String getString(int i, Object... objArr) throws NotFoundException {
        return this.f3739a.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws NotFoundException {
        return this.f3739a.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) throws NotFoundException {
        return this.f3739a.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f3739a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws NotFoundException {
        return this.f3739a.getTextArray(i);
    }

    public String[] getStringArray(int i) throws NotFoundException {
        return this.f3739a.getStringArray(i);
    }

    public int[] getIntArray(int i) throws NotFoundException {
        return this.f3739a.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) throws NotFoundException {
        return this.f3739a.obtainTypedArray(i);
    }

    public float getDimension(int i) throws NotFoundException {
        return this.f3739a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws NotFoundException {
        return this.f3739a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws NotFoundException {
        return this.f3739a.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f3739a.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        return this.f3739a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) throws NotFoundException {
        return this.f3739a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) throws NotFoundException {
        return this.f3739a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.f3739a.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) throws NotFoundException {
        return this.f3739a.getMovie(i);
    }

    public int getColor(int i) throws NotFoundException {
        return this.f3739a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws NotFoundException {
        return this.f3739a.getColorStateList(i);
    }

    public boolean getBoolean(int i) throws NotFoundException {
        return this.f3739a.getBoolean(i);
    }

    public int getInteger(int i) throws NotFoundException {
        return this.f3739a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws NotFoundException {
        return this.f3739a.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) throws NotFoundException {
        return this.f3739a.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) throws NotFoundException {
        return this.f3739a.getXml(i);
    }

    public InputStream openRawResource(int i) throws NotFoundException {
        return this.f3739a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws NotFoundException {
        return this.f3739a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws NotFoundException {
        return this.f3739a.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f3739a.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f3739a.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f3739a.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f3739a.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f3739a != null) {
            this.f3739a.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f3739a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f3739a.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f3739a.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) throws NotFoundException {
        return this.f3739a.getResourceName(i);
    }

    public String getResourcePackageName(int i) throws NotFoundException {
        return this.f3739a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) throws NotFoundException {
        return this.f3739a.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) throws NotFoundException {
        return this.f3739a.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f3739a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f3739a.parseBundleExtra(str, attributeSet, bundle);
    }
}
