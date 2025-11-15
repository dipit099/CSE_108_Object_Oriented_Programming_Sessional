#include<iostream>
#define UNDEFINED 0
#define LINE 1
#define RECTANGLE 2
#define CUBOID 3

using namespace std;

class Shape
{
    int type;
public:
    Shape(int type)
    {
        this->type = type;
    }
    virtual ~Shape()
    {
      
        cout << "Destructing shape\n";
    
    }
    virtual int area()
    {
        return -1;
    }
    virtual int volume()
    {
        return -1;
    }
    int get_type()
    {
        return type;
    }
    void set_type(int type)
    {
        this->type = type;
    }
};


class Line: public Shape
{

    int length;
public:
    Line(int type, int length):Shape(type)
    {
        this->length = length;
    }
    // your code
    virtual ~Line()
    {
        cout << "Destructing line\n";
    }
    virtual int getlength()
    {
        return length;
    }
    virtual int area()
    {
        return 0;
    }
    virtual int volume()
    {
        return 0;
    }
};

class Rectangle: public Line
{
    int width;
public:
    Rectangle(int type, int length, int width):Line(LINE,length)
    {
        this->width = width;
    }
    // your code
    virtual ~Rectangle()
    {
        cout << "Destructing rectangle\n";
    }
    virtual int getwidth()
    {
        return width;
    }
    virtual int area()
     {
        return getlength()*width;
    }
    virtual int volume()
    {
        return 0;
    }


};

class Cuboid: public Rectangle
{
    int height;
public:
    Cuboid(int type, int length, int width, int height):Rectangle(RECTANGLE, length,width)
    {
        this->height = height;
    }
    // your code
    virtual ~Cuboid()
    {
        cout << "Destructing cuboid\n";
    }
    virtual int area()
    {
        return 2*(getlength()*getwidth() + getwidth()*height + height*getlength());
    }
    virtual int volume()
    {
        return getlength()*getwidth()*height;
    }
};


int main()
{
    Shape s(UNDEFINED);
    cout << s.area() << endl;       //-1
    cout << s.volume() << endl; //-1

    Line l(LINE, 5);
    cout << l.area() << endl; // 0
    cout << l.volume() << endl; // 0

    Rectangle r(RECTANGLE, 5, 2);
    cout << r.area() << endl; // 10
    cout << r.volume() << endl; // 0

    Cuboid c(CUBOID, 5, 2, 4);
    cout << c.area() << endl; // 76
    cout << c.volume() << endl; // 40


    Shape *s1;
    s1 = &l;
    cout << s1->area() << endl; // 0
    cout << s1->volume() << endl; // 0

    Shape* s2;
    s2 = &r;
    cout << s2->area() << endl; // 10
    cout << s2->volume() << endl; // 0


    Shape* s3;
    s3 = &c;
    cout << s3->area() << endl; // 76
    cout << s3->volume() << endl; // 40

    //write destructor function and observe (by printing something)
    // the order of constructor and destructor call

    return 0;
}