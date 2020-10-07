## Virtual Function

### Disclaimer
The programmers coming from **C++** background to **Java** normally think that where is the Virtual function?  In Java there is no keyword names **“virtual“**.

### Introduction
In object-oriented programming, a virtual function or virtual method is a function or method whose behaviour can be overridden within an inheriting class by a function with the same signature to provide the polymorphic behavior.

Therefore according to definition, every non-static method in JAVA is by default virtual method except **final** and **private** methods. The methods which cannot be inherited for polymorphic behavior is not a virtual method.

```java
import java.util.*;

public class Animal{
   public void eat(){
      System.out.println("I eat like a generic Animal.");
   }

   public static void main(String[] args){
      List<Animal> animals = new LinkedList<Animal>();

      animals.add(new Animal());
      animals.add(new Wolf());
      animals.add(new Fish());

      for (Animal currentAnimal : animals){
         currentAnimal.eat();
      }
   }
}

public class Wolf extends Animal{
   @Override
   public void eat(){
      System.out.println("I eat like a wolf!");
   }
}

public class Fish extends Animal{
   @Override
   public void eat(){
      System.out.println("I eat like a fish!");
   }
}
```

**Output**
```
I eat like a generic Animal.
I eat like a wolf!
I eat like a fish!
```


### Pure Virtual Function

According to C++, a Pure virtual function is a virtual function for which we don’t have implementations in the class it is declared. Rather it has to be overridden and defined in the Subclass. An **abstract** method in Java can be considered as a pure virtual function. Let’s take an example to understand this better.

```java
abstract class Animal{
    abstract void talk(); //this is a pure virtual function
}
class Dog extends Animal{
    void talk(){
        System.out.println("I am a Dog, I bark");
    }
}

class Cat extends Animal{
    void talk(){
        System.out.println("I am a Cat, I meow");
    }
}

public class MainClass{
    public static void main(String args[]){
        Animal dogObj = new Dog();
        Animal catObj = new Cat();
        dogObj.talk();
        catObj.talk()
    }
}
```

**Output**
```
I am a Dog, I bark
I am a Cat, I meow
```