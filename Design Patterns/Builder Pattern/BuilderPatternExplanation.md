### Builder Pattern

### Introduction

Builder pattern is a creational design pattern that lets you construct complex objects step by step, the main idea is to separate the construction from the representation and make like this object creation more readable.
The pattern allows you to produce different types and representations of an object using the same construction code.

### Advantages

- Create different representations for the same object.
- Encapsulate code for construction and representation.

### Disadvantages

- Create a separate Builder for each object.

### Programming

"AccountBuilder" will be our object and we will create a special Builder for it (on this case that Builder is named "Builder"). With this new Builder we separated the construction from the representation.

We will create inside the Builder a method call Build() that is going to work like a constructor and is going to be the one called for construct the "AccountBuilder" object.