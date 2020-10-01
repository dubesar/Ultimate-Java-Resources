import java.io.*; 
import java.util.*;

//https://www.geeksforgeeks.org/synchronized-in-java/

//A class to print a message
class Printer{
    synchronized void printDocument(int n,String s){
        for(int i=0;i<10;i++){
            System.out.println("Doc is "+s+" "+i);
        }
    }
}

//first thread
class MyThread extends Thread{
    Printer mRef;

    MyThread(Printer p){
        mRef=p;
    }

    @Override
    public void run(){
        mRef.printDocument(10,"MyProfile");
    }
}

//second thread
class YourThread extends Thread{
    Printer yRef;

    YourThread(Printer p){
        yRef=p;
    }

    @Override
    public void run(){
        yRef.printDocument(10,"YourProfile");
    }
}

//Driver Class
class MyClass{
    public static void main(String args[]){
        //operation
        Printer printer=new Printer();
        
        
        MyThread myThread=new MyThread(printer);
        YourThread yourThread=new YourThread(printer);
        
        //start thread
        myThread.start();
        yourThread.start();
    }
}
