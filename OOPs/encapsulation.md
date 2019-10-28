### Encapsulation
Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates

Example of encapsulation is a capsule. Basically, capsule encapsulate several combinations of medicine. If combinations of medicine are variables and methods then the capsule will act as a class and the whole process is called Encapsulation.

### Advantages of Encapsulation:

1) Data Hiding: The user will have no idea about the inner implementation of the class. It will not be visible to the user that how the class is storing values in the variables. He only knows that we are passing the values to a setter method and variables are getting initialized with that value.
2) Increased Flexibility: We can make the variables of the class as read-only or write-only depending on our requirement. If we wish to make the variables as read-only then we have to omit the setter methods like setName(), setAge() etc. from the above program or if we wish to make the variables as write-only then we have to omit the get methods like getName(), getAge() etc. from the above program
3) Reusability: Encapsulation also improves the re-usability and easy to change with new requirements.
4) Testing code is easy: Encapsulated code is easy to test for unit testing.

>Example Code:

    class Employee
    {  
    private String name;  
        
    public String getName()
    {  
    return name;  
    }  
    public void setName(String name){  
    this.name=name;
    }  
    }  

    class Demo
    {  
    public static void main(String[] args)
    {  
    Employee e=new Employee();  
    e.setName("Harry");  
    System.out.println(e.getName());  
    }  
    }  


>Output:

    Harry
