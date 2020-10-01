import java.io.*; 
import java.util.*;

class Printer{
    synchronized void printDocument(int n,String s){
        for(int i=0;i<10;i++){
            System.out.println("Doc is "+s+" "+i);
        }
    }
}

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

class MyClass{
    public static void main(String args[]){
        Printer printer=new Printer();
        MyThread myThread=new MyThread(printer);
        YourThread yourThread=new YourThread(printer);
        myThread.start();
        yourThread.start();
    }
}
