class MyClass{
    private int x;
    //var y=9; //not for instance variable
    MyClass() {
        this.x = 0;
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }
}
public class RefVarDemo {
    public static void main(String[] args) {
        var mc = new MyClass(); //initilize must
        System.out.println(mc.getX());
        mc.setX(10);
        System.out.println(mc.getX());
        var str = "Hello World";
        System.out.println(str);
    }
}
