## Inheritance in Java

This project is going to be an example to show you how to use Inheritance in Java (actually it is same for almost all
the Object Oriented Programming Languages).

Use abstract superclass if there is a clear class hierarchy. Abstract class can contain partial implementation (such as
instance variables and methods). Interface cannot contain any implementation, but merely defines the behaviors.


## What is Inheritance ?

In OOP, we often organize classes in hierarchy to avoid duplication and reduce redundancy. The classes in the lower
hierarchy inherit all the variables (static attributes) and methods (dynamic behaviors) from the higher hierarchies. A
class in the lower hierarchy is called a subclass (or derived, child, extended class). A class in the upper hierarchy is
called a superclass (or base, parent class). By pulling out all the common variables and methods into the superclasses,
and leave the specialized variables and methods in the subclasses, redundancy can be greatly reduced or eliminated as
these common variables and methods do not need to be repeated in all the subclasses.

A subclass inherits all the variables and methods from its superclasses, including its immediate parent as well as all
the ancestors. It is important to note that a subclass is not a "subset" of a superclass. In contrast, subclass is a
"superset" of a superclass. It is because a subclass inherits all the variables and methods of the superclass; in
addition, it extends the superclass by providing more variables and methods.

In Java, you define a subclass using the keyword "extends", e.g.,
```Java
class Goalkeeper extends SoccerPlayer {......}
class MyApplet extends java.applet.Applet {.....}
class Cylinder extends Circle {......}

```

## Types of Inheritance in java

On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.

In java programming, multiple and hybrid inheritance is supported through interface only. We will learn about interfaces later.

1) **Single Inheritance** : When a class inherits another class, it is known as a single inheritance. In the example given below, Dog class inherits the Animal class, so there is the single inheritance.

**`Syntax:` -**
 ```
class Animal{  
void eat(){
	System.out.println("eating...");}  
}  
class Dog extends Animal{  
	void bark(){System.out.println("barking...");}  
}  
class TestInheritance{  
	public static void main(String args[]){  
		Dog d=new Dog();  
		d.bark();  
		d.eat();  
}}  
```
