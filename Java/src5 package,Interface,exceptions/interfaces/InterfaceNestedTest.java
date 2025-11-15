package interfaces;

class A {
    // non-nested interfaces can be default or public
    // nested interfaces can be private/protected/public/default/static
    interface NestedIF {
        boolean isNonNegative(int x);
        default void f1() {
        System.out.println("f1");
         }
    }
    
}

class B implements A.NestedIF {
    @Override
    public boolean isNonNegative(int x) {
        return x >= 0;
    }
}

public class InterfaceNestedTest {
    public static void main(String[] args) {
        A.NestedIF nif = new B();
        System.out.println(nif.isNonNegative(100));
        System.out.println(nif.isNonNegative(-10));
        nif.f1();
        B objB = new B();
        System.out.println(objB.isNonNegative(100));
        System.out.println(objB.isNonNegative(-10));
        objB.f1();
    }
}
