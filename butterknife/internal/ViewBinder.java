package butterknife.internal;

import butterknife.Unbinder;

public interface ViewBinder<T> {
    Unbinder bind(Finder finder, T t, Object obj);
}
