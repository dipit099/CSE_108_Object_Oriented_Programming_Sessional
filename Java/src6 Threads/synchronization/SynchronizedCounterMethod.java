package synchronization;

class SharedCounter1 {
    private int counter;

    SharedCounter1() {
        this.counter = 0;
    }

    public synchronized void increment() {   // synchronized method
        this.counter++;
    }
    
    public int get() {
        return this.counter;
    }

    void count() {
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }
}

class ThreadCounterSyncMethod implements Runnable {
    SharedCounter1 sharedCounter;
    Thread t;

    public ThreadCounterSyncMethod(SharedCounter1 s, String name) {
        sharedCounter = s;
        t = new Thread(this, name); //this use krsi to specify kon class er run call hbe
        t.start();
    }

    public void run() {
        // synchronized(sharedCounter){  //synchronized block
        //     sharedCounter.count(); // tokhn ei statement ta synchronized hobe ..not the count function
        //which means ei statement ta call e hbe one by one thread...1 - 10000 then 10000 - 20000 evabe execute hbe
        // }
        sharedCounter.count();
    }
}

public class SynchronizedCounterMethod {
    public static void main(String[] args) {
        SharedCounter1 sharedCounter = new SharedCounter1();
        ThreadCounterSyncMethod ob1 = new ThreadCounterSyncMethod(sharedCounter, "T1");
        ThreadCounterSyncMethod ob2 = new ThreadCounterSyncMethod(sharedCounter, "T2");
        ThreadCounterSyncMethod ob3 = new ThreadCounterSyncMethod(sharedCounter, "T3");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sharedCounter.get());
    }
}
