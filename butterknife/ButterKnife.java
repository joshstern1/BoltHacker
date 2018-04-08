package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.util.Property;
import android.view.View;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, ViewBinder<Object>> BINDERS = new LinkedHashMap();
    static final ViewBinder<Object> NOP_VIEW_BINDER = new C10391();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    final class C10391 implements ViewBinder<Object> {
        C10391() {
        }

        public Unbinder bind(Finder finder, Object obj, Object obj2) {
            return Unbinder.EMPTY;
        }
    }

    public interface Action<T extends View> {
        void apply(T t, int i);
    }

    public interface Setter<T extends View, V> {
        void set(T t, V v, int i);
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static Unbinder bind(Activity activity) {
        return getViewBinder(activity).bind(Finder.ACTIVITY, activity, activity);
    }

    public static Unbinder bind(View view) {
        return getViewBinder(view).bind(Finder.VIEW, view, view);
    }

    public static Unbinder bind(Dialog dialog) {
        return getViewBinder(dialog).bind(Finder.DIALOG, dialog, dialog);
    }

    public static Unbinder bind(Object obj, Activity activity) {
        return getViewBinder(obj).bind(Finder.ACTIVITY, obj, activity);
    }

    public static Unbinder bind(Object obj, View view) {
        return getViewBinder(obj).bind(Finder.VIEW, obj, view);
    }

    public static Unbinder bind(Object obj, Dialog dialog) {
        return getViewBinder(obj).bind(Finder.DIALOG, obj, dialog);
    }

    static ViewBinder<Object> getViewBinder(Object obj) {
        Class cls = obj.getClass();
        if (debug) {
            Log.d(TAG, "Looking up view binder for " + cls.getName());
        }
        return findViewBinderForClass(cls);
    }

    private static ViewBinder<Object> findViewBinderForClass(Class<?> cls) {
        ViewBinder<Object> viewBinder = (ViewBinder) BINDERS.get(cls);
        if (viewBinder == null) {
            String name = cls.getName();
            if (name.startsWith("android.") || name.startsWith("java.")) {
                if (debug) {
                    Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
                }
                return NOP_VIEW_BINDER;
            }
            try {
                viewBinder = (ViewBinder) Class.forName(name + "_ViewBinder").newInstance();
                if (debug) {
                    Log.d(TAG, "HIT: Loaded view binder class.");
                }
            } catch (ClassNotFoundException e) {
                if (debug) {
                    Log.d(TAG, "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                viewBinder = findViewBinderForClass(cls.getSuperclass());
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to create view binder for " + name, e2);
            } catch (Throwable e22) {
                throw new RuntimeException("Unable to create view binder for " + name, e22);
            }
            BINDERS.put(cls, viewBinder);
            return viewBinder;
        } else if (!debug) {
            return viewBinder;
        } else {
            Log.d(TAG, "HIT: Cached in view binder map.");
            return viewBinder;
        }
    }

    @SafeVarargs
    public static <T extends View> void apply(List<T> list, Action<? super T>... actionArr) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (Action apply : actionArr) {
                apply.apply((View) list.get(i), i);
            }
        }
    }

    @SafeVarargs
    public static <T extends View> void apply(T[] tArr, Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            for (Action apply : actionArr) {
                apply.apply(tArr[i], i);
            }
        }
    }

    public static <T extends View> void apply(List<T> list, Action<? super T> action) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.apply((View) list.get(i), i);
        }
    }

    public static <T extends View> void apply(T[] tArr, Action<? super T> action) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            action.apply(tArr[i], i);
        }
    }

    @SafeVarargs
    public static <T extends View> void apply(T t, Action<? super T>... actionArr) {
        for (Action apply : actionArr) {
            apply.apply(t, 0);
        }
    }

    public static <T extends View> void apply(T t, Action<? super T> action) {
        action.apply(t, 0);
    }

    public static <T extends View, V> void apply(List<T> list, Setter<? super T, V> setter, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            setter.set((View) list.get(i), v, i);
        }
    }

    public static <T extends View, V> void apply(T[] tArr, Setter<? super T, V> setter, V v) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            setter.set(tArr[i], v, i);
        }
    }

    public static <T extends View, V> void apply(T t, Setter<? super T, V> setter, V v) {
        setter.set(t, v, 0);
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(List<T> list, Property<? super T, V> property, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            property.set(list.get(i), v);
        }
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(T[] tArr, Property<? super T, V> property, V v) {
        for (Object obj : tArr) {
            property.set(obj, v);
        }
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(T t, Property<? super T, V> property, V v) {
        property.set(t, v);
    }

    public static <T extends View> T findById(View view, int i) {
        return view.findViewById(i);
    }

    public static <T extends View> T findById(Activity activity, int i) {
        return activity.findViewById(i);
    }

    public static <T extends View> T findById(Dialog dialog, int i) {
        return dialog.findViewById(i);
    }
}
