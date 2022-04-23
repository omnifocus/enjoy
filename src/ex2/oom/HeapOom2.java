package ex2.oom;

import java.util.LinkedList;
import java.util.List;

/**
 * -Xms30m -Xmx30m -XX:+PrintGCDetails
 * GC调优  -- 生产服务器推荐开启(默认是关闭)
 * -XX:+HeapDumpOnOUtOfMemoryError
 */
public class HeapOom2 {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        int i=0;
        while(true) {
            i++;
            if (i % 1000 == 0)
                Thread.sleep(10);
            list.add(new Object());
        }
    }
}
