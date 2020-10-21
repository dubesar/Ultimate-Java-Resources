# Constructor

Constructor is a block of code that initializes the newly created object. A constructor resembles an instance method in java but it’s not a method as it doesn’t have a return type. In short constructor and method are different(More on this at the end of this guide). People often refer constructor as special type of method in Java.

Constructor has same name as the class and looks like this in a java code.

 ```
public class MyClass{
   //This is the constructor
   MyClass(){
   }
   ..
} 
```


## How does a constructor work

To understand the working of constructor, lets take an example. lets say there is a class called MyClass.
When creating the object of MyClass is like this:

 ```
MyClass obj = new MyClass()

```
The new keyword here creates the object of class MyClass and invokes the constructor to initialize this newly created object.

### A simple constructor program in java

The code snippet below shows how an object obj of class Hello created, and  then display the instance variable name of the object. As you can see that the output is 'constructor of oop' which is what have passed to the name during initialization in constructor. This shows that when creating the object obj the constructor got invoked. In this example, the using of this keyword, which refers to the current object, object obj in this example.

>Example Code:
```java
public class Hello {
   String name;
   //Constructor
   Hello(){
      this.name = "constructor of oop";
   }
   public static void main(String[] args) {
      Hello obj = new Hello();
      System.out.println(obj.name);
   }
}
```

>Output:
       
     Constructor of oop
     
     
 The information is taken,   
  * https://beginnersbook.com/
  * https://www.w3schools.com/




