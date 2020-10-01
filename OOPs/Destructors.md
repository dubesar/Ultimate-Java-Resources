
## This is a C++ specific topic

Destructor is a member function of a class which destructs or deletes an object.

A destructor is called automatically:
(0) when the object goes out of scope
(1) the function ends
(2) the program ends
(3) a block containing local variables ends
(4) a delete operator is called

Destructors have same name as the class preceded by a tilde (~)
Destructors don’t take any argument and don’t return anything
There can be only one destructor for a class

```cpp
#include <iostream>

using namespace std;

class A_Class { // Tip: This could be a struct instead of class, as eveery memeber of it is public
public: // IMPORTANT: destructors should be public
    // a destructor
    ~A_Class() {
        cout << "destructor called\n";
    }
};

int main() {
    { // scope starts
        A_Class obj;
    } // scope ends, destructor called
    
    A_Class* obj_ptr = new A_Class;
    delete obj_ptr; // destructor called
    return 0;
}
```