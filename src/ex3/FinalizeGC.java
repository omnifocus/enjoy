package ex3;

public class FinalizeGC {
    public static FinalizeGC instance = null;
    public void isAlive() {System.out.print("I'm alive");}

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed..");
        FinalizeGC.instance = this;
    }

    public static void main(String[] args) throws InterruptedException {
        instance = new FinalizeGC();
        instance = null;

        System.gc();
Thread.sleep(1000);
        if (instance != null) {
            instance.isAlive();
        } else {
            System.out.println("I'm dead!");
        }

        System.out.println("-------------------");
        instance = null;
        System.gc();
        Thread.sleep(1000);
        if (instance != null) {
            instance.isAlive();
        } else {
            System.out.println("I'm dead!");
        }


    }

}
