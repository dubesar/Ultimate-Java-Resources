### Inheritance
Inheritance is an important pillar of OOP(Object Oriented Programming). It is the mechanism in Java by which one class is allow to inherit the features(fields and methods) of another class.

The real life example of inheritance is child and parents, all the properties of father are inherited by his son.

#### Important terminology
##### Super Class: 
The class whose features are inherited is known as super class(or a base class or a parent class).

##### Sub Class: 
The class that inherits the other class is known as sub class(or a derived class, extended class, or child class).

### Important facts about inheritance in Java

1). Default superclass: Except Object class, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of Object class.

2). Superclass can only be one: A superclass can have any number of subclasses. But a subclass can have only one superclass. This is because Java does not support multiple inheritance with classes. Although with interfaces, multiple inheritance is supported by java.

3). Inheriting Constructors: A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.

4). Private member inheritance: A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods(like getters and setters) for accessing its private fields, these can also be used by the subclass.


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
