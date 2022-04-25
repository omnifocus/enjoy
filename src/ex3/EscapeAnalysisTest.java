package ex3;

/**
 * -XX:-DoEscapeAnalysis -XX:PrintGC
 */
public class EscapeAnalysisTest {
    static class MyObject {
        int a;
        double b;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i=0; i < 50000000;i++) {
            allocate();
        }

        System.out.println((System.currentTimeMillis() - start) + "ms");
        Thread.sleep(600000);

    }

    private static void allocate() {
        MyObject myObject = new MyObject();
    }
}
