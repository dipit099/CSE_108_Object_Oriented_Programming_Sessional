package interfaces;

interface Alpha {
    default void reset() {
        System.out.println("Alpha's reset");
    }
}

interface Beta {
    default void reset() {
        System.out.println("Beta's reset");
        
    }
    // default void reset2() {
    //     System.out.println("Beta's reset");
    // }
}

public class InterfaceMultipleInheritanceTest implements Alpha, Beta {
    
    public void reset() {
        System.out.println("Beta's reset2");
    }
    public static void main(String[] args) {
    InterfaceMultipleInheritanceTest obj = new InterfaceMultipleInheritanceTest();
    obj.reset();
    
}

}
