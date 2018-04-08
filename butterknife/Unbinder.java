package butterknife;

public interface Unbinder {
    public static final Unbinder EMPTY = new C10401();

    final class C10401 implements Unbinder {
        C10401() {
        }

        public void unbind() {
        }
    }

    void unbind();
}
