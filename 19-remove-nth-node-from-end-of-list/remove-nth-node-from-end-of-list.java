/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode curr = head;
       ListNode prev = null;
       ListNode curr1 = head;
       int size = 0;

       while(curr.next != null){
            prev = curr;
            curr = curr.next;
            size++;
       }

       if(n == 1) {
        if(prev == null){
            return null;
        }
            prev.next = null;
       } else {
            int r = size - n;
            if(r == -1){
                return head.next;
            }
            while(r-- > 0){
                curr1 = curr1.next;
            }

            if(curr1.next != null){
                curr1.next = curr1.next.next;
            }
       }

       return head;
    }
}