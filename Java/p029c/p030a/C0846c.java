package android.support.v7.p029c.p030a;

import java.lang.reflect.Array;

final class C0846c {
    static final /* synthetic */ boolean f2788a = (!C0846c.class.desiredAssertionStatus());

    public static <T> T[] m5476a(T[] tArr, int i, T t) {
        if (f2788a || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0846c.m5474a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] m5475a(int[] iArr, int i, int i2) {
        if (f2788a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[C0846c.m5474a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static int m5474a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    private C0846c() {
    }
}
