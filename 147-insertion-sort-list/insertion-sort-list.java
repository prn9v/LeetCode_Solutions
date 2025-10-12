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
    public ListNode insertionSortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);;
        while(head != null){
            pq.add(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
             curr.next = pq.poll();
        curr = curr.next;   
        }

        curr.next = null;
        return dummy.next;
    }
}