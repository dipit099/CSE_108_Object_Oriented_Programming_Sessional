package interfaces;

interface MyIFStatic {
    int getNumber();

    default String getString() {
        return "Default String";
    }

    // This is a static interface method (introduced in Java 8)
    // not inherited by either an implementing class or a subinterface.
    static int getDefaultNumber() {
        return 3;
    }
}

class MyIFStaticImp implements MyIFStatic {
    // Only getNumber() defined by MyIF needs to be implemented.
    // getString() can be allowed to default.
    //private or default or static need not to be implemented.
    public int getNumber() {
        return 100;
    }
    // static int getDefaultNumber() {
    //     return 4;
    // }

}

public class InterfaceStaticMethodTest {
    public static void main(String[] args) {
        System.out.println(MyIFStatic.getDefaultNumber());
    }
}
