### Aggregation
Aggregation is a term which is used to refer one way relationship between two objects.In OOP, aggregation represents HAS-A relationship, which means when a class contains reference of another class known to have aggregation.
The HAS-A relationship is based on usage, rather than inheritance. When an object A contains a reference to another object B or we can say Object A has a HAS-A relationship with Object B, then it is termed as Aggregation.

#### Advantage
Aggregation helps in reusing the code. Object B can have utility methods and which can be utilized by multiple objects. Whichever class has object B then it can utilize its methods.

#### Example Code
##### Address.java

        public class Address {  
        String city,state,country;  

        public Address(String city, String state, String country) {  
            this.city = city;  
            this.state = state;  
            this.country = country;  
            }  

          }

##### Emp.java

        public class Emp {  
        int id;  
        String name;  
        Address address;  

        public Emp(int id, String name,Address address) {  
            this.id = id;  
            this.name = name;  
            this.address=address;  
        }  

        void display(){  
        System.out.println(id+" "+name);  
        System.out.println(address.city+" "+address.state+" "+address.country);  
        }  

        public static void main(String[] args) {  
        Address address1=new Address("gzb","UP","india");  
        Address address2=new Address("gno","UP","india");  

        Emp e=new Emp(111,"varun",address1);  
        Emp e2=new Emp(112,"arun",address2);  

        e.display();  
        e2.display();  

        }  
        }  

#### Output
       O111 varun
       gzb UP india
       112 arun
       gno UP india  
