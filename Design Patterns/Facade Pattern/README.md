### Facade Pattern

### Introduction

The facade pattern is appropriate when you have a complex system that you want to expose to clients in a simplified way, or you want to make an external communication layer over an existing system which is incompatible with the system. Facade deals with interfaces, not implementation. Its purpose is to hide internal complexity behind a single interface that appears simple on the outside.

PS:
The Facade pattern is used when you want to hide an implementation or it is about changing interface of some class or set of classes. 

Abstract factory pattern is used when you want to hide the details on constructing instances.

### Advantages

We can use the facade pattern to collate all the complex method calls and related code blocks and channelizes it through one single Façade class. In this way with respect to client there is only one single call. Even if we make changes to the subsystem packages / class and their logic there is no impact to the client call.

### Drawbacks/Consequences

One of the drawback is that the subsystem methods are connected to the Façade layer. If the structure of the subsystem changes then it will require subsequent change to the Facade layer and client methods.


### Programming

We are going to create a Shape interface and concrete classes implementing the Shape interface. A facade class ShapeMaker is defined as a next step.

ShapeMaker class uses the concrete classes to delegate user calls to these classes. FacadePattern class, will use ShapeMaker class to show the results.
