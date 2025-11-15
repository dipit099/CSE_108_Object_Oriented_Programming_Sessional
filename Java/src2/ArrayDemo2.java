class A {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class ArrayDemo2 {
    public static void main(String[] args) {
        A[] array = new A[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new A(); //This line creates a new object of class A and assigns it to the i-th slot of the array.
            array[i].setA(i);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("Object of class A: " + array[i].getA());
        }
    }
}