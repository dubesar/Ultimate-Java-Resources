### Composite Pattern

### Introduction

Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.

This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.

### Advantages

- It defines class hierarchies that contain primitive and complex objects.
- It makes easier to you to add new kinds of components.
- It provides flexibility of structure with manageable class or interface.

### Disadvantages

- Composite Design Pattern makes it harder to restrict the type of components of a composite.
- Composite Design Pattern can make the design overly general. It makes harder to restrict the components of a composite. Sometimes you want a composite to have only certain components. With Composite, you can not rely on the type system to enforce those constraints for you. Instead you will have to use run-time checks.

### Programming

We have a class Employee which acts as composite pattern actor class. CompositePattern, our demo class will use Employee class to add department level hierarchy and print all employees.