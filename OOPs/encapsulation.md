### Encapsulation
Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates

Example of encapsulation is a capsule. Basically, capsule encapsulate several combinations of medicine. If combinations of medicine are variables and methods then the capsule will act as a class and the whole process is called Encapsulation.

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