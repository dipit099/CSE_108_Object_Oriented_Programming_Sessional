

public class ExceptionThrows {
    public static void f() throws IllegalAccessException    //"throws"
     {
        System.out.println("In f()");
        throw new IllegalAccessException("f");  //"throw"
    }

    public static void main(String args[])  {
        try {
            f();
        } catch (IllegalAccessException e) {
            System.out.println("Inside catch of main()");
            e.printStackTrace();    //printStackTrace() prints the stack trace of the exception
        }
    }
}
	