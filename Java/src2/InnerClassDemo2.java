class Outer2
{
    int outer_x = 100;

    void test() { 
        Inner inner = new Inner();
        inner.display(Outer2.this);
    }

    class Inner {       
        
        int y = 10; 
        int outer_x = 200;
        void display(Outer2 outer) {
           // System.out.println(Outer2.this.outer_x);    //to get outer_x of outer class
           System.out.println("inner class er outer_x = " + outer_x);
              System.out.println("outer class er outer_x = " +outer.outer_x);
        }
    }

     void showy() {
        // to access from outer class
        Inner obj = new Inner();
        System.out.println(obj.y);
        
    }
}

public class InnerClassDemo2 {
    public static void main(String[] args)
     {
        Outer2 outer = new Outer2();
        outer.test();
        outer.showy();
    }
}
