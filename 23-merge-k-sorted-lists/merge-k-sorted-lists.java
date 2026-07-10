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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        for(ListNode list : lists) {
            if(list != null) {
                pq.offer(list);
            }
        }

        while(!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            curr.next = smallest;

            if(smallest.next != null) {
                pq.offer(smallest.next);
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}