package synchronization;

class TestClass {

    public void f0() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //add keyword here
    public synchronized void f1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void f2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized static void fs() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static void fs2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


public class SynchronizedTest {
    public static void main(String[] args) {
        TestClass t1 = new TestClass();
        TestClass t2 = new TestClass();
        // duita sync method ekta class er obj diye parallelly chalano possible  na
        // one obj can monitor one sync method at a time
        //new Thread(t1::f1, "T1").start();
       // new Thread(t1::f2, "T2").start();

        // ekta sync method ekta class er duita obj diye parallelly chalano possible
       

        //new Thread(t1::f1, "T1").start();
        //new Thread(t2::f1, "T2").start();

        new Thread(t1::f1, "T1").start();
        new Thread(t1::f1, "T2").start();
        
        //one obj can monitor one sync and one non sync method parallelyl
         //new Thread(t1::f2, "T2").start();
         //new Thread(t1::f0, "T3").start();

        //Both thread point to same function
        //new Thread(TestClass::fs, "T1").start(); // can monitor one at a time ...same reference type think like this
        //new Thread(TestClass::fs2, "T2").start();
    }
}
