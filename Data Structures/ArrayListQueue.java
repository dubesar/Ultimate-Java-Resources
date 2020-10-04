import java.util.ArrayList;

/**
 * This class represents the concept of a classical, theoretical Queue. It supports the two basic operations,
 * Enqueue and Dequeue, as well, as isEmpty and size.
 *
 * @param <T> Being a generic class, one can choose which type to fill the queue with.
 */
public class ArrayListQueue<T> {

    private final ArrayList<T> queue;
    private final int capacity;

    ArrayListQueue(int capacity) {
        this.queue = new ArrayList<T>(capacity);
        this.capacity = capacity;
    }

    public void enqueue(T element) {
        if (this.queue.size() == this.capacity) {
            System.err.println("Queue is full");

            return;
        }

        this.queue.add(element);
    }

    public T dequeue() {
        if (this.queue.isEmpty()) {
            System.err.println("Queue is empty");

            return null;
        }

        T element = this.queue.get(0);
        this.queue.remove(0);

        return element;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int size() {
        return this.queue.size();
    }
}

class ArrayListQueueExample {
    public static void main(String[] args) {
        ArrayListQueue<Integer> intQueue = new ArrayListQueue<Integer>(10);

        //Fills queue to capacity
        for(int i = 0; i < 10; i++) {
            intQueue.enqueue(i);
        }

        //Should print an error
        intQueue.enqueue(-1);

        //Flushes the queue completely
        for(int i = 0; i < 10; i++) {
            int element = intQueue.dequeue();

            System.out.println(element);
        }

        //Should print an error and return null
        if (intQueue.dequeue() == null) {
            //Should be true
            System.out.println(intQueue.isEmpty());
        }


    }
}
