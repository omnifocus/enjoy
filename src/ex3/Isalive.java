package ex3;

/**
 * -XX:+printGC
 */
public class Isalive {
    public Object instance = null;
    private byte[] bigSize = new byte[10 * 1024 * 1024];

    public static void main(String[] args) {
        Isalive objectA = new Isalive();
        Isalive objectB = new Isalive();
        objectA.instance = objectB;
        objectB.instance = objectA;

        //切断可达
        objectA = null;
        objectB = null;

        //强制垃圾回收
        System.gc();
    }
}
