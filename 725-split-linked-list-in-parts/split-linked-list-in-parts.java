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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        if(head == null) {
            return ans;
        }

        int size = 0;
        ListNode curr = head;

        while(curr != null) {
            size++;
            curr = curr.next;
        }

        int baseSize = size / k;
        int extraNodes = size % k;

        curr = head;

        for (int pos = 0; pos < k; pos++) {
            if (curr == null) {
                ans[pos] = null;
                continue;
            }

            ans[pos] = curr;

            int currentPartSize = baseSize + (extraNodes > 0 ? 1 : 0);
            if (extraNodes > 0) {
                extraNodes--;
            }

            ListNode prev = null;

            for (int i = 0; i < currentPartSize; i++) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
        }

        return ans;
    }
}