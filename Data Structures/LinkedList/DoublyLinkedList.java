/**
 * A class that implements doubly linked list.
 *
 * @param <E> The type of the elements stored in the list
 */
public class DoublyLinkedList<E> {
    private int size;
    private ListNode<E> head;
    private ListNode<E> tail;
    public DoublyLinkedList(){
        this.size = 0;
        this.head = new ListNode<E>(null);
        this.tail = new ListNode<E>(null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    /*Implementing some List interface methods to get some idea*/

    /**
     * @return: returning DoublyLinkedList size
     */
    public int size() {
        return this.size;
    }

    /**
     * adding data to the end of the list
     *
     * @param data: data to be added into the end of list
     */
    public boolean add(E data){
        ListNode<E> node = new ListNode<E>(data);
        // adding the node at the end
        node.setNext(this.tail);
        node.setPrev(this.tail.getPrev());
        this.tail.getPrev().setNext(node);
        this.tail.setPrev(node);
        size++;
        return true;
    }

    /**
     * get data from a specified index
     * @param index
     */
    public E get(int index) {
        int counter = 0;
        ListNode<E> nodeCounter = this.head;
        while(counter <= index){
            nodeCounter = nodeCounter.getNext();
            counter++;
        }
        return nodeCounter.getData();
    }

    /**
     *
     * @param index: index position where the node to add
     * @param data: Data contained in that node
     */
    public boolean add(int index, E data){
        ListNode<E> node = new ListNode<E>(data);
        ListNode<E> nodeCounter = this.head;
        int counter = 0;
        while (counter <= index){
            nodeCounter = nodeCounter.getNext();
            counter++;
        }
        node.setNext(nodeCounter);
        node.setPrev(nodeCounter.getPrev());
        node.getPrev().setNext(node);
        nodeCounter.setPrev(node);
        return true;
    }
}

/**
 *
 * @param <E> The type of element ListNode can have
 */
class ListNode<E>{
    private ListNode<E> prev = null;
    private ListNode<E> next = null;
    private E data;
    public ListNode(E theData){
        this.data = theData;
    }

    public E getData() {
        return data;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public ListNode<E> getPrev() {
        return prev;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public void setPrev(ListNode<E> prev) {
        this.prev = prev;
    }
}
