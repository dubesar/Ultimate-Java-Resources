/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
  * Detection of a cycle/loop in a Singly-Linked List by using Two pointer approach specifically Fast and Slow pointers.  
  */

public class CycleDetectionInLinkedList{

    public ListNode detectCycle(ListNode head) 
    {
        if(head==null || head.next==null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast)
            {                
                break;
            }
                        
        }
        
        if(slow==fast)
        {
            slow = head;
            
            while(slow!=fast)
            {
                slow = slow.next;
                fast = fast.next;                
            }
            
            return fast;
        }        
        return null;
       
    }        
}