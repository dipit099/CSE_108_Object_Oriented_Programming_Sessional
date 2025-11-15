abstract class Figure {
    double d1, d2;

    Figure (double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    public abstract double area();

}

// your code
class Triangle extends Figure
{
    Triangle(double m, double n)
    {
        // d1=a;
        // d2=n;
        super(m,n);
    }
    public double area()
    {
        return 0.5*d1*d2;
    }
}
class Rectangle extends Figure
{
    Rectangle(double m, double n)
    {
        super(m,n);
    }
    public double area()
    {
        return d1*d2;
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);

        Figure ref;

        ref = r;
        System.out.println("Area: " + ref.area());

        ref = t;
        System.out.println("Area: " + ref.area());
    }
}

/* Write the necessary classes to achieve the following output of the main method.

Area: 45.0
Area: 40.0

*/