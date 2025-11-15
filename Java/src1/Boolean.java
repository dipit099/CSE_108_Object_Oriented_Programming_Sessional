public class Boolean {
    public static void main(String[] args) {
        int a = 10;
        if (a > 0) // if (a) will give compilation error
        {
            System.out.println("Inside If");
        }
        boolean b = false;
        if (b)      // ok if variable is boolean type
        {
            System.out.println("Inside If");
        }
        else
        {
            System.out.println("Inside Else");
        }
    }
}
