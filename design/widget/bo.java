package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class bo {
    private static final ThreadLocal<Matrix> f1349a = new ThreadLocal();
    private static final ThreadLocal<RectF> f1350b = new ThreadLocal();
    private static final Matrix f1351c = new Matrix();

    public static void m2084a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) f1349a.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f1349a.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.set(f1351c);
            matrix = matrix2;
        }
        m2085a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f1350b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void m2085a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m2085a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
