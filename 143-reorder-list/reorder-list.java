public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = getMiddle(head);
        ListNode second = reverseList(middle.next);
        middle.next = null;
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
