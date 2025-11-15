public class StaticTest1 {
    static int a = 3, b;
    int c;

    
    static void f1(int x) {
        System.out.println("f1 callind");
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // System.out.println("c = " + c);   //non-static variable c cannot be referenced from a static context
    }

    int f2() {
        System.out.println("executing f2");
        //c=b; //OK here
        //System.out.println("OKA");
        return a * b;
    }
    static
    {
        System.out.println("static block: a incre");
        a= 10;
    }

    static {
        System.out.println("static block: b incre");
        b = a * 4;
        //c = b; // Error
    }
    {
        System.out.println("using new to create obj");
    }
    

    public static void main(String[] args) {
        f1(42); // StaticTest.f1(84);
        System.out.println("b = " + b);
        
         StaticTest1 st = new StaticTest1();
        int m = st.f2();
        System.out.println("m = "+m);
    }
}
