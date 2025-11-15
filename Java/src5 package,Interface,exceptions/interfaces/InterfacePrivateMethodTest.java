package interfaces;

interface MyIFPrivate {
    default String f1()
    {
        login();
        return "Hello";
    }

    default String f2() {
        login();        //calling in this way !! WOWOWOW
        return "World";
    }
    

    // This is a private interface method (introduced in Java 9)
    // can be called only by a default method or another private method of the same
    // interface
    private void login() {
        System.out.println("login");
    }
}

class MyIFPrivateImp implements MyIFPrivate {
}

public class InterfacePrivateMethodTest {
    public static void main(String[] args) {
        MyIFPrivate ifp = new MyIFPrivateImp();
        System.out.println(ifp.f1());
        System.out.println(ifp.f2());

        //ifp.login(); // Error, no such method in MyIFPrivate
        MyIFPrivateImp ifp2 = new MyIFPrivateImp();
        System.out.println(ifp2.f1());
        System.out.println(ifp2.f2());
    }
}
