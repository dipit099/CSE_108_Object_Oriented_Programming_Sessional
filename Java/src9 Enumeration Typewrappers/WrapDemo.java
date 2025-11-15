
public class WrapDemo {
    public static void main(String args[]) {

        Integer iOb = new Integer(100); // boxing

        int i = iOb.intValue(); // unboxing  "intValue() is a method of Integer class"
        System.out.println(i + " " + iOb);

        Integer jOb = 200; // auto boxing bcz auto is created by new in backend
        int j = jOb; // auto unboxing


        System.out.println(j + " " + jOb);
    }
}