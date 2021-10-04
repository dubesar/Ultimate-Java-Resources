### Proxy Pattern

### Introduction

In proxy pattern, a class represents functionality of another class. This type of design pattern comes under structural pattern.
Proxy pattern is used when we need to create a wrapper to cover the main object’s complexity from the client.
In proxy pattern, we create object having original object to interface its functionality to outer world.

### Advantages

- One of the advantages of Proxy pattern is security.

- This pattern avoids duplication of objects which might be huge size and memory intensive. This in turn increases the performance of the application.

- The remote proxy also ensures about security by installing the local code proxy (stub) in the client machine and then accessing the server with help of the remote code.

### Disadvantages

- This pattern introduces another layer of abstraction which sometimes may be an issue if the RealSubject code is accessed by some of the clients directly and some of them might access the Proxy classes. This might cause disparate behaviour.

### Programming

- We are going to create an Image interface and concrete classes implementing the Image interface.

- ProxyImage is a a proxy class to reduce memory footprint of RealImage object loading.

- ProxyPatternDemo, our demo class, will use ProxyImage to get an Image object to load and display as it needs.

