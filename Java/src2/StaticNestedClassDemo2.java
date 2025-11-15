class OuterStaticInner2 {

    private int outer_x = 100;
    static int static_x = 200;

    
    static class Inner {
        int inner_x = 100;

        void print() {
            OuterStaticInner2 outer = new OuterStaticInner2();
            System.out.println(outer.outer_x);  // static to non-static thats why we need object
            System.out.println(static_x);
            System.out.println(inner_x);
        }
    }
    void func()
    {
        Inner objInner = new Inner();
        objInner.print();
    }
}

public class StaticNestedClassDemo2 {
    public static void main(String[] args) 
    {
        OuterStaticInner2.Inner x = new OuterStaticInner2.Inner();
        x.print();
        System.out.println();

        OuterStaticInner2 outerobj = new OuterStaticInner2();
        outerobj.func();
    }
}