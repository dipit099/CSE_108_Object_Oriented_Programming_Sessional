package synchronization;
class SharedCounter {
    private int counter;

    SharedCounter() {
        this.counter = 0;
    }

    public void increment() {
        this.counter++;     //one thread goes to increase it 1 to 2..but ..majh pothe arek thread eshe porlo
        //ager thread pura kaj shesh korar agei....tokhon jkhn value nite chae tokhn
        //new thread 1 e pelo so 1 to 2 holo..but it should do 2 to 3
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


class ThreadCounterNoSync implements Runnable {
    SharedCounter sharedCounter;
    Thread t;

    public ThreadCounterNoSync(SharedCounter s, String name) {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        sharedCounter.count();
    }
}

public class NonSynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter(); // one object
        ThreadCounterNoSync ob1 = new ThreadCounterNoSync(sharedCounter, "T1"); //3threads sharing same object sharedCounter!!
        ThreadCounterNoSync ob2 = new ThreadCounterNoSync(sharedCounter, "T2");
        ThreadCounterNoSync ob3 = new ThreadCounterNoSync(sharedCounter, "T3");
        try {
            ob1.t.join();  //waits for the thread to die
            ob2.t.join();
            ob3.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sharedCounter.get());
    }
}
