package ex2;

/*
 -Xms30m -Xmx30m -XX:MaxMetaspaceSize=30m -XX:+UseConcMarkSweepGC -XX:-UseCompressedOops

 */
public class JVMStack {
    private int work(int x) throws Exception {
        int z = (x+5) * 10;
        Thread.sleep(Integer.MAX_VALUE);
        return z;
    }

    public static void main(String[] args) throws Exception {
        JVMStack jvmStack = new JVMStack();
        jvmStack.work(10);
    }
}
