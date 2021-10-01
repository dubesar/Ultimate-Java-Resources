### Decorator Pattern

### Introduction

Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.

This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.

### Advantages

- It is flexible than inheritance because inheritance adds responsibility at compile time but decorator pattern adds at run time.
- We can have any number of decorators and also in any order.
- It extends functionality of object without affecting any other object.

### Disadvantages

- Code maintainability is difficult because this pattern creates lots of similar decorators which are sometimes hard to maintain and distinguish.

### Programming

- We are going to create a Shape interface and concrete classes implementing the Shape interface. We will then create an abstract decorator class ShapeDecorator implementing the Shape interface and having Shape object as its instance variable.

- RedShapeDecorator is concrete class implementing ShapeDecorator.

- DecoratorPatternDemo, our demo class will use RedShapeDecorator to decorate Shape objects.