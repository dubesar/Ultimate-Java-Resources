### Manipulators
Manipulators, which are also known as setters or mutators, are a way of controlling how users of your code may properly modify private data fields.
Manipulators are usually methods in the class with the private data field with their own implementations -- the implementation can be as simple as `privateField = inputField`, or the code for setting can involve a multitude of checks and processing.
As you can see, manipulators give a lot of room for developers to control how they want their classes to function.

### Naming Conventions
As per [JavaBeans](https://www.oracle.com/java/technologies/javase/javabeans-spec.html) naming conventions, manipulators (or setters) should be named as `set<Datafield>(param args)`, where `<Datafield>` is the datafield you want to modify.

### Example
