package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class C0401x {

    public interface C0400a {
        void m2794a();
    }

    public abstract SavedState mo374a(Fragment fragment);

    public abstract Fragment mo375a(int i);

    public abstract Fragment mo376a(Bundle bundle, String str);

    public abstract Fragment mo377a(String str);

    public abstract ah mo378a();

    public abstract void mo380a(int i, int i2);

    public abstract void mo381a(Bundle bundle, String str, Fragment fragment);

    public abstract void mo382a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean mo383b();

    public abstract boolean mo384c();

    public abstract List<Fragment> mo385d();

    public abstract boolean mo386e();
}
