package ex3.reftype;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * -Xms20m -Xmx20m
 */
public class TestSoftRef {

    private static class User {
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User u = new User("1","panda");  // = 强引用
        SoftReference<User> userSoftRef = new SoftReference<>(u); // 软引用
        u = null; // 去掉强引用，确保这个实例只有userSoftRef的软引用
        System.out.println(userSoftRef.get());  //看当前对象是否还在
        System.gc();
        System.out.println("after gc:");
        System.out.println(userSoftRef.get());

        //往堆中填充数据，导致OOM

        List<byte[]> list = new LinkedList<>();
        try {
            for (int j=0;j<100;j++) {
                list.add(new byte[1024*1024]);
            }
        } catch (Throwable e) {
            System.out.println("Exception........" + userSoftRef.get());
        }

    }
}
