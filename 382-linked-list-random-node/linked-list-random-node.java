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

    List<Integer> nums = new ArrayList<>();
    Random rand = new Random();

    public Solution(ListNode head) {
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int idx = rand.nextInt(nums.size());
        return nums.get(idx);
    }
}