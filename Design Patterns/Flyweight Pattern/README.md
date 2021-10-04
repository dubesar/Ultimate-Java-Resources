### Flyweight Design Pattern

### Introduction

Flyweight pattern is one of the structural design patterns as this pattern provides ways to decrease object count thus improving application required objects structure. Flyweight pattern is used when we need to create a large number of similar objects (say 105). One important feature of flyweight objects is that they are immutable. This means that they cannot be modified once they have been constructed.

In Flyweight pattern we use a HashMap that stores reference to the object which have already been created, every object is associated with a key. Now when a client wants to create an object, he simply has to pass a key associated with it and if the object has already been created we simply get the reference to that object else it creates a new object and then returns it reference to the client.

### Advantages

- It reduces the number of objects.
- It reduces the amount of memory and storage devices required if the objects are persisted.

### Disadvantages

- Reduce memory usage by sharing heavy objects.
- Improved data caching for higher response time.
- Increased performance due to a lesser number of heavy objects.

### Implementation

We implement the creation of Attackers and Defenders In the game of Valorant. So we have 2 classes one for Attackers and other for Defenders. Whenever an Agent asks for a weapon we assign him/her/them the asked weapon. In the mission, Attacker's task is to plant a Spike while the Defenders have to diffuse the Spike.
