package threads;

class NewThread3 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--)
            {
                System.out.println("Child Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

public class ImplementsThread2 {

    //2nd way if you dont create a thread object in NewThread3 class
    public static void main(String[] args) {
        Runnable r = new NewThread3();  //reference dhore rakhe
        Thread t = new Thread(r); // kon class er run call korbe seta bujhaite
        t.start();
    }
}