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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head.next;
        ListNode curr = head;
        ListNode nextNode = head.next;
        ListNode prev = new ListNode(0);

        while(curr != null && nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = curr;
            curr.next = temp;
            prev.next = nextNode;
            prev = curr;
            curr = temp;
            if(curr != null){
                nextNode = curr.next;
            }
        }

        return dummy.next;
    }
}