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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);
        ListNode dummy = new ListNode();
        ListNode curr2 = dummy;

        while(!list.isEmpty()){
            curr2.next = new ListNode(list.remove(0));
            curr2 = curr2.next;
        }

        return dummy.next;
    }
}