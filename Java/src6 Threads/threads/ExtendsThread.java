package threads;

class NewThread2 extends Thread         // "new thread" create korar jonno extends Thread...
// extend korsi so we cant extend any other class...this is the limitation
{

    NewThread2() {
        super("Extends Thread");   //Thread r name change krte[java default ekta naam dey]     
        System.out.println(this); 
        start();                        //start call korlei then execution shuru hy Thread er...and it calls "run"
        //start();  start(); // makes no difference..ekbar e call hobe "run"
    }

    // This is the "entry" point for the thread.
    @Override
    public void run() {
        System.out.println("Starting child thread.");
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(1000);         
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

public class ExtendsThread {
    public static void main(String[] args) throws Exception {
        new NewThread2();
        for (int i = 10; i > 0; i--) {
            System.out.println("Main Thread: " + i);
            Thread.sleep(2000); //this indicates main thread
        }
    }
}
