package threads;

class NewThread1 implements Runnable  //its a Interface// must implement "run"
{
    Thread t;                       // need to create a thread object to call "start" which calls "run"

    NewThread1() {
        t = new Thread(this); 
        // "this" use krtasi karon jate 'start'--"NewThread1" er "run" method ta call kore  ie "this" object er run method ta 
        t.start();
    }

       @Override
    public void run() {
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

public class ImplementsThread {
    public static void main(String[] args) throws Exception {
        new NewThread1();
        for (int i = 10; i > 0; i--) {
            System.out.println("Main Thread: " + i);
            Thread.sleep(2000);
        }
    }
}
