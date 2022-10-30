import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = l3;
        int num = 0;
        int carry = 0;

        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null)
                num = l1.val + l2.val + carry;
            else if(l1 == null)
                num = l2.val + carry;
            else if(l2 == null)
                num = l1.val + carry;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

            if(num > 9){
                l3.val = num%10;
                carry = 1;
            }
            else{
                l3.val = num;
                carry = 0;
            }

            if(l1 != null || l2 != null){
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        if(carry == 1){
            l3.next = new ListNode(1);
        }
        return head;
    }
}