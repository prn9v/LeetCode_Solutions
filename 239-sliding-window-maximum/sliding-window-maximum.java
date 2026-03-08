import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k +1];

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(j);

            if (deque.peekFirst() < i) {
                deque.pollFirst();
            }

            if (j - i + 1 == k) {
                ans[i] = nums[deque.peekFirst()];
                i++;
            }
            j++;
        }

        return ans;
    }
}