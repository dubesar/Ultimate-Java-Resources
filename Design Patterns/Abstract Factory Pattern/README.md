### Abstract Factory Pattern

### Introduction

Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
### Advantages

- You can be sure that the products you’re getting from a factory are compatible with each other.
- You avoid tight coupling between concrete products and client code.

### Disadvantages

- The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.

### Programming

Here we consider creating UI Components for Windows and MacOS. GUI components gets created depending on the kind of the OS.

- We create GUIFactory interface that declares two components - Button and CheckBox
- Create interface for Button and its implementations (No. of interfaces - 1 , classes - 2).
- Same goes for CheckBox (No. of interfaces - 1, classes - 2).
- Create implementations for GUIFactory interface for the two OSes. Add concrete implementations done above.(No. of classes - 2)
- Create factory initialization code(GUI class) somewhere in the app. It should instantiate one of the concrete factory classes.(No. of classes - 1)
- Main Method acts as a client code here - that calls the GUI class, sends the OSType information and is unaware of the complexity involved.  