

import java.util.Random;

public class ExceptionTryNested {
    public static void main(String args[]) {
        int a = 10, b, c;
        Random r = new Random();
        try {
            for (int i = 1; i <= 20; i++)
                try {
                    b = r.nextInt();
                    c = r.nextInt();
                    a = 12345 / (b / c);
                    System.out.println("DONE "+i);
                } catch (ArithmeticException e) {
                    System.out.println(e);
                    a = 0;
                }//printed after try and catch
                 finally {
                    System.out.println("ALLTIME " + i + ": " + a);
                }
        } catch (ArithmeticException e) {
            System.out.println("Outer catch:");
            System.out.println(e);
        }
    }
}
	