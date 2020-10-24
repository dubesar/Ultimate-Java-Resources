## Constructor In Java

Constructor is a block of code that initializes the newly created object. A constructor resembles an instance method in java but it’s not a method as it doesn’t have a return type.
In short constructor and method are different(More on this at the end of this guide). People often refer constructor as special type of method in Java


Constructor has same name as the class and looks like this in a java code.

```Java
public class MyClass{
   //This is the constructor
   MyClass(){
   }
}
```


### How does a constructor work

To understand the working of constructor, lets take an example. 

```Java
MyClass obj = new MyClass()

The new keyword here creates the object of class MyClass and invokes the constructor to initialize this newly created object

#### A simple constructor program in java

Here created an object obj of class Hello and then displayed the instance variable name of the object. As you can see that the output is 'my constructor' which is what we have passed to the name during initialization in constructor. This shows that when creating the object obj the constructor got invoked. In this example we have used this keyword, which refers to the current object, object obj in this example. 

**`Syntax:` -**
 ```
public class Hello {
   String name;
   //Constructor
   Hello(){
      this.name = "BeginnersBook.com";
   }
   public static void main(String[] args) {
      Hello obj = new Hello();
      System.out.println(obj.name);
   }
}
```

Output of the above code example
my constructor




