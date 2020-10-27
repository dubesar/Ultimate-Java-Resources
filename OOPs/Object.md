## Objects in Java

An entity that has state and behavior is known as an object.
Some of the examples are chair, bike, marker, pen, table, car, etc. It can be physical or logical (tangible and intangible)


#### What are the characteristics within an object

1) **State** : represents the data (value) of an object.
2) **Behavior** : represents the behavior (functionality) of an object such as deposit, withdraw, etc.
3) **Identity**: An object identity is typically implemented via a unique ID. The value of the ID is not visible to the external user. However, it is used internally by the JVM to identify each object uniquely.


#### An object is an instance of a class. A class is a template or blueprint from which objects are created. So, an object is the instance(result) of a class.

## Object Definitions:

1) An object is a real-world entity.
2) An object is a runtime entity.
3) The object is an entity which has state and behavior.
4) The object is an instance of a class.



## Creating an Object

As mentioned previously, a class provides the blueprints for objects. So basically, an object is created from a class. In Java, the new keyword is used to create new objects.
There are three steps when creating an object from a class.

1) **Declaration** − A variable declaration with a variable name with an object type.
2) **Instantiation** − The 'new' keyword is used to create the object.
3) **Initialization** − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.


Following is an example of creating an object −,
**`Syntax:` -**
 ```
public class Puppy {
   public Puppy(String name) {
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name );
   }

   public static void main(String []args) {
      // Following statement would create an object myPuppy
      Puppy myPuppy = new Puppy( "tommy" );
   }
}
```




## Types of Inheritance in java

On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.

In java programming, multiple and hybrid inheritance is supported through interface only. We will learn about interfaces later.

1) **Single Inheritance** : When a class inherits another class, it is known as a single inheritance. In the example given below, Dog class inherits the Animal class, so there is the single inheritance.


