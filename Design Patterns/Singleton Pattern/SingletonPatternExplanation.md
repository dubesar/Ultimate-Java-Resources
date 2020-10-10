### Singleton Pattern

### Introduction

Singleton is a design pattern use usually on OOP. The main idea of this pattern is to restrict the number of instances of an object to only one "single" instance.

It is useful when we need exactly one object, but if we don't think good about our needs can be convert to an anti-pattern.

### Programming

The idea is that you need to call the method getInstance() of the class for obtain the instance (there is no other form because the rest have to be private). One you call the method it will take a look to the variable call "Instance", in case of don't have any instance of the object it will create automatically having like this only one possible instance.