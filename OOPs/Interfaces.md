# Interfaces

* An Interface is a collection of abstract methods therefore achieving 100% abstraction. It is a blueprint of a class.
An interface is defined as:

```
interface Animal{

}
```
Here above I have created an interface named Animal.

* In an interface, all the methods have empty bodies. 

```
interface Animal{
    void eat();
    void sleep();
}
```
Here I have declared two methods eat() and sleep(). These methods are by default public and abstract.

* An Interface can contain any number of methods.
There can be any number of methods in an interface

```
interface Animal{
    void eat();
    void sleep();
       //many more
}
```

* A class will always implement an interface.

```
interface Animal{
    void eat();
    void sleep();
}
class Dog implements Animal{
    
}
```
In the above code the class Animal will implement the interface Animal to use its methods.

* A class which extends the interface needs to define all the methods present in the interface, unless abstract.

```
interface Animal{
    void eat();
    void sleep();
}
class Dog implements Animal{
    void eat(){
        System.out.println("Eat");
    }
    void sleep(){
        System.out.println("sleep");
    }
}
```

Here the class Dog has to define all the methods of the interface Animal because Dog class is not abstract. If the Dog class was abstract then there wasnt a need to define all the methods.

* An interface always extends another interface but implemented by a class.

```
interface LivingBeings{
    void walk();
    void breathe();
}

interface Animal extend LivingBeings{
    void eat();
    void sleep();
}
class Dog implements Animal{
    void eat(){
        System.out.println("Eat");
    }
    void sleep(){
        System.out.println("sleep");
    }
}
```
* Interfaces cannot contain Constructors.


## Uses of Interfaces:

* Interfaces are used when there is a need for multiple inheritence.

As we know that java do not allow multiple inheritence. So to ivercome this we can make interfaces and a class can implement any number of these interfaces.

```
interface LivingBeings{
    void walk();
    void breathe();
}

interface Animal extend LivingBeings{
    void eat();
    void sleep();
}
class Dog implements Animal,LivingBeings{
    void eat(){
        System.out.println("Eat");
    }
    void sleep(){
        System.out.println("sleep");
    }
}
```

Here the class Dog extends the Animal and LivingBeings interface.

* Interfaces are used to hide details and only show the important details of ab object.
