import java.util.*

public class heap{
    public static void main(String[] args){
    
        // Min Heap: --> to keep the min element always on top, so you can access it in O(1).
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        // Max Heap: --> to keep the max element always on top, the same order as above.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        /*
        add --> to add element to the queue. O(log n)
        remove --> to get and remove the min/max. O(log n)
        peek --> to get, but not remove the min/max. O(1)
        */
    }
}
