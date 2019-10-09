### Inheritance
Inheritance is an important pillar of OOP(Object Oriented Programming). It is the mechanism in Java by which one class is allow to inherit the features(fields and methods) of another class.

The real life example of inheritance is child and parents, all the properties of father are inherited by his son.

#### Important terminology
##### Super Class: 
The class whose features are inherited is known as super class(or a base class or a parent class).

##### Sub Class: 
The class that inherits the other class is known as sub class(or a derived class, extended class, or child class).


>Example Code:

     class Faculty
     {  
    float salary=30000;  
     }  
     class Science extends Faculty
     { 
     float bonous=2000;
     public static void main(String args[])
     {
     Science obj=new Science(); 
     System.out.println("Salary is:"+obj.salary);  
     System.out.println("Bonous is:"+obj.bonous);  
     }  
     } 

>Output:
       
     Salary is:30000.0
     Bonous is:2000.0