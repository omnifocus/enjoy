package ex2.oom;

/*
-Xms30m -Xmx30m -XX:+PrintGCDetails
堆一共30m，直接溢出
 */
public class HeapOom {
    public static void main(String[] args) {
        String[] str = new String[35*1000*1000];
    }
}
