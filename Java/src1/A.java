//package mypackage2;
public class A {
    private int a;

    public A()
    {
        System.out.println("In Constructor");
        this.a = 0;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public int getA()
    {
        return this.a;
    }


    // psvm Shortcut for main method
    public static void main(String args[])  // static use korle we dont( Not mandatory to create an object)
    {
        A ob;
        ob = new A();
        // A ob = new A() is same as before but in a single statement        
        ob.setA(10);

        //sout shortcut for System.out.println
        System.out.println(ob.getA());



        //System.out.println("hello");
    }
}

