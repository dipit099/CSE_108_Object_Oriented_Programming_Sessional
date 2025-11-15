package threads;

import javax.sound.midi.Track;

public class CreateThread {

    public void f1() {
        for (int i = 10; i > 0; i--) 
        {
            System.out.println("f1(): " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void f2() {
        for (int i = 10; i > 0; i--) {
            System.out.println("f2(): " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       
        CreateThread ct = new CreateThread();
        Thread t1 = new Thread(ct::f1, "T1");  // tokhon f1 ta e "run" method hye jabe and start will  call it  

        Thread t2 = new Thread(CreateThread::f2, "T3");  
        //or          new Thread(CreateThread::f2, "T3").start();  // tokhn abar "join"  use korte parbona ..it needs thread reference

        t1.start();  
        t2.start();

        System.out.println(t1.isAlive());
        t1.join();  
        t2.join();                          // Main Thread waits for t1 and t2 to die     
        System.out.println("Main thread exiting.");
    

    }

    
}
