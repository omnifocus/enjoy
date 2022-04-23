package ex2.stringconstantpool;

public class PersonString {

    public static void main(String[] args) {
        P p = new P();
        p.name = String.valueOf(350);
        String x = new String("abc").intern();
        String y = new String("abc").intern();
        System.out.println(x ==y);
        System.out.println(x =="abc");


    }
}

class P {
    String name;
}
