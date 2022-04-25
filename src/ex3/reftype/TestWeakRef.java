package ex3.reftype;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class TestWeakRef {

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
        WeakReference<User> userSoftRef = new WeakReference<>(u); // 弱引用
        u = null; // 去掉强引用，确保这个实例只有userSoftRef的软引用
        System.out.println(userSoftRef.get());  //看当前对象是否还在
        System.gc();
        System.out.println("after gc:");
        System.out.println(userSoftRef.get());

    }
}
