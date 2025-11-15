// #include<iostream>
#include <bits/stdc++.h>
using namespace std;
class Point2D
{
    double x, y;

public:
    Point2D()
    {
        x = 0;
        y = 0;
    }
    Point2D(double x, double y);
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    void print();
    ~Point2D();
    // your code
    Point2D operator+(Point2D obj);
    Point2D operator*(double n);
    bool operator==(Point2D obj2);
    bool operator!=(Point2D obj2);
};

Point2D::Point2D(double argx, double argy)
{
    x = argx;
    y = argy;
}

void Point2D::setX(double argx)
{
    x = argx;
}

void Point2D::setY(double argy)
{
    y = argy;
}

double Point2D::getX()
{
    return x;
}

double Point2D::getY()
{
    return y;
}

void Point2D::print()
{
    cout << "(" << x << "," << y << ")";
        cout << endl<<endl;
}

Point2D::~Point2D()
{
    x = 0;
    y = 0;
}

// your code
Point2D Point2D::operator+(Point2D obj)
{
    Point2D temp;
    temp.setX(this->x + obj.getX());

    temp.setY(this->y + obj.getY());
    return temp;
}
Point2D Point2D::operator*(double n)
{
    Point2D temp;
    double a;
    a = getX();
    temp.setX(a * n);
    a = getY();
    temp.setY(a * n);
    return temp;
}
bool Point2D::operator==(Point2D obj2)
{
    double x1 = this->getX();
    double x2 = obj2.getX();
    double y1 = this->getY();
    double y2 = obj2.getY();
    if (x1 == x2 && y1 == y2)
        return true;
    else
        return false;
}
bool Point2D::operator!=(Point2D obj2)
{
    double x1 = this->getX();
    double x2 = obj2.getX();
    double y1 = this->getY();
    double y2 = obj2.getY();
    if (x1 != x2 || y1 != y2)
        return true;
    else
        return false;
}
class Circle
{
    Point2D center;
    double radius;

public:
    Circle();
    Circle(Point2D c, double r);
    void setCenter(Point2D c);
    void setRadius(double r);
    Point2D getCenter();
    double getRadius();
    void print();
    ~Circle();
    // your code
    
    Circle operator+(Point2D P);
    Circle operator*(double n);
    Circle operator+(Circle obj);
    Circle operator-(Circle obj);
    bool operator==(Circle obj);
    bool operator>(Circle obj);
    bool operator>=(Circle obj);
    bool operator<(Circle obj);
    bool operator<=(Circle obj);
    Circle operator++();
    Circle operator++(int unused);
};

Circle::Circle()
{
    center.setX(0);
    center.setY(0);
    radius = 0;
}

Circle::Circle(Point2D c, double r)
{
    center.setX(c.getX());
    center.setY(c.getY());
    radius = r;
}

void Circle::setCenter(Point2D c)
{
    center.setX(c.getX());
    center.setY(c.getY());
}

void Circle::setRadius(double r)
{
    radius = r;
}
Point2D Circle::getCenter()
{
    return center;
}
double Circle::getRadius()
{
    return radius;
}

void Circle::print()
{
    cout << "[Center: ";
    center.print();
    cout << " Radius: " << radius;
    cout << "]";
        cout << endl<<endl;
}

Circle::~Circle()
{
    center.setX(0);
    center.setY(0);
    radius = 0;
}
// your code
Circle Circle ::operator+(Point2D P)
{
    Circle new_circle;
    Point2D temp = this->getCenter();
    temp.setX(temp.getX() + P.getX());
    temp.setY(temp.getY() + P.getY());
    new_circle.setCenter(temp);
    new_circle.setRadius(this->getRadius());
    return new_circle;
}

Circle Circle ::operator*(double n)
{
    Circle new_circle;
    Point2D temp = this->getCenter();
    double radius = this->getRadius();
    temp.setX(temp.getX() * n);
    temp.setY(temp.getY() * n);
    radius *= n;
    new_circle.setCenter(temp);
    new_circle.setRadius(radius);
    return new_circle;
}

Circle Circle ::operator+(Circle obj)
{
    double radius1 = this->getRadius();
    double radius2 = obj.getRadius();
    double alpha = radius1 / (radius1 + radius2);
    Circle new_circle;
    Point2D new_point;
    Point2D pot1 = this->getCenter();
    Point2D pot2 = obj.getCenter();
    new_point.setX(pot1.getX() * alpha + pot2.getX() * (1 - alpha));
    new_point.setY(pot1.getY() * alpha + pot2.getY() * (1 - alpha));
    new_circle.setRadius(radius1 + radius2);
    new_circle.setCenter(new_point);
    return new_circle; 
}
Circle Circle ::operator-(Circle obj)
{
    double radius1 = this->getRadius();
    double radius2 = obj.getRadius();
    double alpha = radius1 / (radius1 + radius2);
    Circle new_circle;
    Point2D new_point;
    Point2D pot1 = this->getCenter();
    Point2D pot2 = obj.getCenter();
    new_point.setX(pot1.getX() * alpha + pot2.getX() * (1 - alpha));
    new_point.setY(pot1.getY() * alpha + pot2.getY() * (1 - alpha));
    new_circle.setRadius(abs(radius1 - radius2));
    new_circle.setCenter(new_point);
    return new_circle;
}
bool Circle ::operator==(Circle obj)
{
    double area1 = 3.1416 * this->getRadius() * this->getRadius();
    double area2 = 3.1416 * obj.getRadius() * obj.getRadius();
    if (area1 == area2)
        return true;
    return false;
}
bool Circle ::operator>(Circle obj)
{
    double area1 = 3.1416 * this->getRadius() * this->getRadius();
    double area2 = 3.1416 * obj.getRadius() * obj.getRadius();
    if (area1 > area2)
        return true;
    return false;
}
bool Circle ::operator>=(Circle obj)
{
    double area1 = 3.1416 * this->getRadius() * this->getRadius();
    double area2 = 3.1416 * obj.getRadius() * obj.getRadius();
    if (area1 >= area2)
        return true;
    return false;
}
bool Circle ::operator<(Circle obj)
{
    double area1 = 3.1416 * this->getRadius() * this->getRadius();
    double area2 = 3.1416 * obj.getRadius() * obj.getRadius();
    if (area1 < area2)
        return true;
    return false;
}
bool Circle ::operator<=(Circle obj)
{
    double area1 = 3.1416 * this->getRadius() * this->getRadius();
    double area2 = 3.1416 * obj.getRadius() * obj.getRadius();
    if (area1 <= area2)
        return true;
    return false;
}
Circle Circle::operator++()
{
    this->setRadius(this->getRadius() + 1);
    return *this;
}
Circle Circle::operator++(int unused)  
{
    Circle new_circle(this->getCenter(),this->getRadius()) ;
    this->radius++;
    return new_circle ;
}

class Rectangle
{
    Point2D topRightPoint, bottomLeftPoint;

public:
    Rectangle();
    Rectangle(Point2D oneCorner, Point2D anotherCorner);
    void setTopRightPoint(Point2D oneCorner);
    void setbottomLeftPoint(Point2D anotherCorner);
    Point2D getTopRightPoint();
    Point2D getBottomLeftPoint();
    void print();
    ~Rectangle();
    // your code
    Rectangle operator+(Point2D obj);
    Rectangle operator*(double n);
};

Rectangle::Rectangle()
{
    topRightPoint.setX(0);
    topRightPoint.setY(0);
    bottomLeftPoint.setX(0);
    bottomLeftPoint.setY(0);
}
Rectangle::Rectangle(Point2D oneCorner, Point2D anotherCorner)
{
    topRightPoint = oneCorner;
    bottomLeftPoint = anotherCorner;
}

void Rectangle::setTopRightPoint(Point2D oneCorner)
{
    topRightPoint = oneCorner;
}
void Rectangle::setbottomLeftPoint(Point2D anotherCorner)
{
    bottomLeftPoint = anotherCorner;
}
Point2D Rectangle::getTopRightPoint()
{
    return topRightPoint;
}
Point2D Rectangle::getBottomLeftPoint()
{
    return bottomLeftPoint;
}
// your code
Rectangle Rectangle::operator+(Point2D obj)
{
    Point2D pot11 = this->getBottomLeftPoint();
    Point2D pot12 = this->getTopRightPoint();
    pot11.setX(pot11.getX() + obj.getX());
    pot11.setY(pot11.getY() + obj.getY());
    pot12.setX(pot12.getX() + obj.getX());
    pot12.setY(pot12.getY() + obj.getY());

    this->setbottomLeftPoint(pot11);
    this->setTopRightPoint(pot12);
    return *this;
}
Rectangle Rectangle::operator*(double n)
{
    Point2D pot11 = this->getBottomLeftPoint();
    Point2D pot12 = this->getTopRightPoint();
    pot11.setX(pot11.getX() * n);
    pot11.setY(pot11.getY() * n);
     pot12.setX(pot12.getX() * n);
    pot12.setY(pot12.getY() * n);

    this->setbottomLeftPoint(pot11);
    this->setTopRightPoint(pot12);
    return *this;
}
void Rectangle::print()
{
    cout << "[Top Right Point: ";
    topRightPoint.print();
    cout << "  Bottom left Point: ";
    bottomLeftPoint.print();
    cout << "]";
    cout << endl<<endl;
}
Rectangle::~Rectangle()
{
    topRightPoint.setX(0);
    topRightPoint.setY(0);
    bottomLeftPoint.setX(0);
    bottomLeftPoint.setY(0);
}
int main()
{
    Point2D p1(5,10),p2(15,10),p3;

    Circle c1(p1,10),c2,c3;

    Rectangle r1(p1,p2),r2;

    cout<<"p1 = ";
    p1.print();;
    cout<<"p2 = ";
    p2.print();
    cout<<"c1 = ";
    c1.print();
    cout<<"r1 = ";
    r1.print();
    p3=p1+p2;
    cout<<"p3=p1+p2   ";
    p3.print();  

    p3=p1*10;
    cout<<"p3=p1*15   ";
    p3.print();

    if(p1==p2){

        cout<<"p1==p2"<<endl;
    }

    if(p1!=p2){

        cout<<"p1!=p2"<<endl;
    }

    c2=c1+p1;
    cout<<"c2=c1+p1 ";
    c2.print();

    c2=c1*5;
    cout<<"c2=c1*10 ";
    c2.print();

    cout<<"c1 ";
    c1.print();
    ;

    cout<<"c2 ";
    c2.print();;;

    c3=c1+c2;
    cout<<"c3=c1+c2";
    c3.print();

    c3=c1-c2;
    cout<<"c3=c1-c2 ";
    c3.print();

    if(c1==c2){

        cout<<"c1 == c2"<<endl;
    }

    if(c1>=c2){

        cout<<"c1 >= c2"<<endl;
    }

    if(c1<=c2){

        cout<<"c1 <= c2"<<endl;
    }

    if(c1<c2){

        cout<<"c1 < c2"<<endl;
    }

    ++c1;
    cout<<"c1++  ";
    c1.print();

    c1++;
    cout<<"++c1   ";
    c1.print();

    c2=c1++;
    cout<<"c2=c1++   ";
    c2.print();

    c2=++c1;
    cout<<"c2=++c1   ";
    c2.print();

    r2=r1+p1;
    cout<<"r2=r1+p1 ";
    r2.print();

    r2=r2*(double)5;
    cout<<"r2*5    ";
    r2.print();




    return 0;
}