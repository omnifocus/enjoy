package ex2.oom;

import java.nio.ByteBuffer;

/*
-XX:MaxDirectMemorySize=100m -XX:+PrintGCDetails
分配128M
 */
public class DirectOom {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocateDirect(128 * 1024 * 1024);
    }
}
