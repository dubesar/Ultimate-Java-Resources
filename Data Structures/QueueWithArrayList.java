import java.io.*;
import java.util.*;

/*
    Queue Implimentation Using ArrayList
    Written By: Divakar Lakhera
 */

/*
        Queue.enQueue(int element)
            - insert element into a queue.
        Queue.deQueue()
            - returns element in FIFO format.
 */
class Queue {
    ArrayList<Integer> buff;
    int noOfElements=0;

    Queue(int n) {
        buff = new ArrayList<Integer>(n);
    }

    void enQueue(int element) {
        buff.add(element);
        noOfElements++;
    }

    int deQueue() {
        if(noOfElements==0)
        {
            System.out.println("No Elements");
            return -1;
        }
        else
        {
            int tmp=buff.get(0);
            buff.remove(0);
            noOfElements--;
            return tmp;
        }
    }

}

class main
{
    public static void main(String []arg) {

        Queue q=new Queue(6);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.enQueue(7);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
