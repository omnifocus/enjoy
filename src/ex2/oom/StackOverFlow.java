package ex2.oom;

public class StackOverFlow {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        a();
    }
}
