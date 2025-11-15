class OuterStaticInner {

    private int outer_x = 100;

    void test() {       //outer class cant call inner classes function...for this it need to create Inner class object
        Inner inner = new Inner();
        inner.display(this);    // this means- Passing OuterStaticInner class obj
    }

    
    static class Inner {
        void display(OuterStaticInner outer) {
            System.out.println(outer.outer_x);  //static to non-static var so need obj to call it
           
        }
    }
}

public class StaticNestedClassDemo {
    public static void main(String[] args) {
        OuterStaticInner outer = new OuterStaticInner();
        //method 1
        outer.test();
        
        OuterStaticInner.Inner x = new OuterStaticInner.Inner();
        //method 2
        x.display(outer);
        int yy=23;
        String str=String.valueOf(yy);
        String str2= Integer.toString(yy);
         
        System.out.println(str);
    }
}