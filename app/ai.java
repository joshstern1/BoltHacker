package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ai {

    public static class C0310a {
        public View f1563a;
    }

    public interface C0311b {
        View mo346a();
    }

    public static String m2379a(View view) {
        return view.getTransitionName();
    }

    public static Object m2376a(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object m2377a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        m2400b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        m2399b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static void m2386a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m2383a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void m2384a(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new aj(m2401c(view)));
    }

    public static Object m2397b(Object obj) {
        if (obj == null) {
            return null;
        }
        Transition transition = (Transition) obj;
        if (transition == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    private static void m2398b(Transition transition, Transition transition2, ArrayList<View> arrayList, boolean z) {
        if (transition != null) {
            int size = transition2 == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                transition.excludeTarget((View) arrayList.get(i), z);
            }
        }
    }

    public static void m2388a(Object obj, Object obj2, Object obj3, ArrayList<View> arrayList, boolean z) {
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        m2398b((Transition) obj, transition2, arrayList, z);
        m2398b(transition, transition2, arrayList, z);
    }

    public static void m2387a(Object obj, Object obj2, Object obj3, View view, C0311b c0311b, View view2, C0310a c0310a, Map<String, String> map, ArrayList<View> arrayList, ArrayList<View> arrayList2, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj3;
        Object obj4 = (Transition) obj2;
        m2398b(transition, transition2, arrayList2, true);
        if (obj != null || obj2 != null) {
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                m2385a(obj4, view2, (Map) map2, (ArrayList) arrayList3);
                m2398b(transition, obj4, arrayList3, true);
                m2398b(transition2, obj4, arrayList3, true);
            }
            view.getViewTreeObserver().addOnPreDrawListener(new ak(view, transition, view2, c0311b, map, map3, arrayList, transition2));
            m2380a(transition, c0310a);
        }
    }

    public static Object m2378a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        Object transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static void m2385a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m2391a(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        m2399b(obj, (ArrayList) arrayList);
    }

    private static void m2391a(List<View> list, View view) {
        int size = list.size();
        if (!m2395a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m2395a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean m2395a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    private static void m2380a(Transition transition, C0310a c0310a) {
        if (transition != null) {
            transition.setEpicenterCallback(new al(c0310a));
        }
    }

    private static Rect m2401c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    private static void m2400b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m2400b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void m2392a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m2392a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m2382a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new am(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
        }
    }

    public static void m2389a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                m2389a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!m2393a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void m2399b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                m2399b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!m2393a(transition) && m2394a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean m2393a(Transition transition) {
        return (m2394a(transition.getTargetIds()) && m2394a(transition.getTargetNames()) && m2394a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m2394a(List list) {
        return list == null || list.isEmpty();
    }
}
