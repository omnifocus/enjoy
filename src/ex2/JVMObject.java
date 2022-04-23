package ex2;
/*
*  -Xms30m -Xmx30m -XX:MaxMetaspaceSize=30m -XX:+UseConcMarkSweepGC -XX:-UseCompressedOops
* */
public class JVMObject {
    public final static String MAN_TYPE = "man";
    public static String WOMAN_TYPE = "woman";

    public static void main(String[] args) throws InterruptedException {
        Teacher T1 = new Teacher();
        T1.setName("mark");
        T1.setSexType(MAN_TYPE);
        T1.setAge(36);

        for (int i=0;i<15;i++) {
            System.gc(); //主动触发GC 15次
        }

        Teacher T2 = new Teacher();
        T2.setName("king");
        T2.setSexType(MAN_TYPE);
        T2.setAge(18);
        Thread.sleep(Integer.MAX_VALUE);
    }
}

class Teacher {
    String name;
    String sexType;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
