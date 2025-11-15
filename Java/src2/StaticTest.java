public class StaticTest {
    static int a = 3, b;
    int c,x;

    int f2() {
        System.out.println("f2 static function calling");
        System.out.println("c = "+c);
        return a * c;
    }

    public StaticTest() {
        System.out.println("Constructor of the StaticTest CLASS");
        a=5;
        c = 100;
    }

    static {
        System.out.println("static block calling");
        b = a * 4;    
        //c = 3; 
         
    }

    {  
         //when  "new" called
        System.out.println("non-static block calling");
        c = 10;     // can be initialised here !!
        System.out.println("c = "+c);
    }

    public static void f1(int x) {
        System.out.println("static function calling");
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        //System.out.println("b = " + c);
        
    }

    

    

    public static void main(String[] args) {
        f1(42); 
        System.out.println("b = " + b);
        StaticTest st = new StaticTest();
        System.out.println("Area = " + st.f2());   
        //need to create obj to access f2
       
        
        
    }
}
