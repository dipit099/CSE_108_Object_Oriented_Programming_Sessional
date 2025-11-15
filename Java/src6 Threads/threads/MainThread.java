package threads;

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();  // currentThread ie main thread
        //no need to write "Start and Run" because it is the main thread so auto start run hye jae


        System.out.println("Current thread: " + t);        
        t.setName("My Thread");
        System.out.println("After name change: " + t);
        System.out.println(Thread.currentThread().getName());  //to get Name of a thread



        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(2000);  //sleep sudhu nijekei sleep kore, onno thread k sleep korte parbe na, currentThread only
                // sleep is a static method
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
