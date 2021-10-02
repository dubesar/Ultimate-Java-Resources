### Bridge Pattern

### Introduction

Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently. This type of design pattern comes under structural pattern as this pattern decouples implementation class and abstract class by providing a bridge structure between them.

This pattern involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes. Both types of classes can be altered structurally without affecting each other.

### Advantages

- It enables the separation of implementation from the interface.
- It improves the extensibility.
- It allows the hiding of implementation details from the client.

### Disadvantages

- Bridge pattern implementation increases code complexity.
- Interfaces with only single implementation.
- Multiple indirection - A level of indirection is introduced as the request is passed from the Abstraction to the actual implementor.

### Programming

We have a DrawAPI interface which is acting as a bridge implementer and concrete classes RedCircle, GreenCircle implementing the DrawAPI interface. Shape is an abstract class and will use object of DrawAPI. BridgePattern, our demo class will use Shape class to draw different colored circle.  