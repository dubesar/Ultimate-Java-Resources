# Abstraction
Data Abstraction is the property by virtue of which only the essential details are displayed to the user.The trivial or the non-essentials units are not displayed to the user. 

Consider a real-life example of a man driving a car. The man only knows that pressing the accelerators will increase the speed of car or applying brakes will stop the car but he does not know about how on pressing the accelerator the speed is actually increasing, he does not know about the inner mechanism of the car or the implementation of accelerator, brakes etc in the car. This is what abstraction is.

### Abstract classes and Abstract methods :

1. An abstract class is a class that is declared with abstract keyword.
2. An abstract method is a method that is declared without an implementation.
3. An abstract class may or may not have all abstract methods. Some of them can be concrete methods
4. A method defined abstract must always be redefined in the subclass,thus making overriding compulsory OR either make subclass itself      abstract.
5. Any class that contains one or more abstract methods must also be declared with abstract keyword.
6. There can be no object of an abstract class.That is, an abstract class can not be directly instantiated with the new operator.
7. An abstract class can have parametrized constructors and default constructor is always present in an abstract class.

### Encapsulation vs Data Abstraction

Encapsulation is data hiding(information hiding) while Abstraction is detail hiding(implementation hiding).
While encapsulation groups together data and methods that act upon the data, data abstraction deals with exposing the interface to the user and hiding the details of implementation.

### Advantages of Abstraction

It reduces the complexity of viewing the things.
Avoids code duplication and increases reusability.
Helps to increase security of an application or program as only important details are provided to the user.

>Example Code

    abstract class Shape  
    { 
    String color; 
   
    // these are abstract methods 
    abstract double area(); 
    public abstract String toString(); 
      
    // abstract class can have constructor 
    public Shape(String color) { 
        System.out.println("Shape constructor called"); 
        this.color = color; 
    } 
      
    // this is a concrete method 
    public String getColor() { 
        return color; 
    } 
    } 

    class Circle extends Shape 
    { 
    double radius; 
      
    public Circle(String color,double radius) { 
  
        // calling Shape constructor 
        super(color); 
        System.out.println("Circle constructor called"); 
        this.radius = radius; 
    } 
  
    @Override
    double area() { 
        return Math.PI * Math.pow(radius, 2); 
    } 
  
    @Override
    public String toString() { 
        return "Circle color is " + super.color +  
                       "and area is : " + area(); 
    }  
    public class Test  
    { 
    public static void main(String[] args) 
    { 
        Shape s1 = new Circle("Red", 2.2);  
          
        System.out.println(s1.toString()); 
    } 
    } 

>Output:

    Shape constructor called
    Circle constructor called
    Circle color is Red and area is : 15.205308443374602
  
