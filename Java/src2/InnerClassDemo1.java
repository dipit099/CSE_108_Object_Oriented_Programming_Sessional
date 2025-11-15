class Outer1 {
    private int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    
    class Inner {
        int inner_x = 200;
        void display() {
            System.out.println(outer_x);    //can access private var of outer class
        }
    }
}

public class InnerClassDemo1 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.test();
        Outer1.Inner innerObj = outer.new Inner();
        innerObj.display();
    }
}
