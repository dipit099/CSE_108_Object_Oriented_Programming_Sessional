/*Consider the class Student that has three private member variables, 
namely roll (integer), name (string), and cgpa (float). 
Write appropriate getter and setter functions along with overloaded constructors 
so the given main function works properly. Also, write a destructor function that sets the roll to 0.*/

#include<iostream>
#include<cstring>
using namespace std;

//Implement the class Student
class Student
{
   private:
      int roll;
      char *name;
      float cgpa;
   public:
      Student(){

      }
      Student(char s[])
      {
         int n= strlen(s); //works with string.h
         name = (char*)malloc(sizeof(char)* n);
         strcpy(name , s);
      }
      Student(int roll)
      {
         this->roll = roll;
      }
      Student(int roll,char s[], float cgpa)
      {
         int n= strlen(s);
         name = (char*)malloc(sizeof(char)* n);
         strcpy(name , s);
         this->roll = roll;
         this->cgpa = cgpa;
      }
      void setroll(int roll)
      { 
         this ->roll = roll;
      }
      void setcg(double cgpa)
      {
         this->cgpa = cgpa;
      }
      void setname(char s[])
      {
         int n= strlen(s);
         name = (char*)malloc(sizeof(char)* n);
         strcpy(name,s);
      }
      char* getname()
      {
         return name;
      }
      int getroll()
      {
         return this->roll;
      }
      float getcg()
      {
         return this->cgpa;
      }
      ~Student()
      {
         free(name);
         this->roll = 0;
      }
};

int main()
{
    Student s1;
    Student s2("Karim");
    Student s3(3);
    Student s4(4, "Rahim", 3.52);
    Student s5(5, "Sakib", 3.92);
    s1.setname("Papon");
    s1.setroll(1);
    s1.setcg(4.00);
    s2.setroll(2);
    s2.setcg(3.8);
    s3.setname("Abdul");
    s3.setcg(3.96);
    float avg=(s1.getcg()+s2.getcg()+s3.getcg()+s4.getcg()+s5.getcg())/5;
    cout<<"Student #1"<<endl;
    cout<<"Roll : "<<s1.getroll()<<endl;
    cout<<"Name : "<<s1.getname()<<endl;
    cout<<"CGPA : "<<s1.getcg()<<endl<<endl;

    cout<<"Student #2"<<endl;
    cout<<"Roll : "<<s2.getroll()<<endl;
    cout<<"Name : "<<s2.getname()<<endl;
    cout<<"CGPA : "<<s2.getcg()<<endl<<endl;

    cout<<"Student #3"<<endl;
    cout<<"Roll : "<<s3.getroll()<<endl;
    cout<<"Name : "<<s3.getname()<<endl;
    cout<<"CGPA : "<<s3.getcg()<<endl<<endl;

    cout<<"Student #4"<<endl;
    cout<<"Roll : "<<s4.getroll()<<endl;
    cout<<"Name : "<<s4.getname()<<endl;
    cout<<"CGPA : "<<s4.getcg()<<endl<<endl;

    cout<<"Student #5"<<endl;
    cout<<"Roll : "<<s5.getroll()<<endl;
    cout<<"Name : "<<s5.getname()<<endl;
    cout<<"CGPA : "<<s5.getcg()<<endl<<endl;

    cout<<"Average of CGPA : "<<avg<<endl;

}