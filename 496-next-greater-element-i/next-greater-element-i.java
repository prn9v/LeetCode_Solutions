import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int max = nums1[i];
            int idx = map.get(nums1[i]);
            idx++;
            while (idx < nums2.length &&  max == nums1[i]) {
                if (max < nums2[idx]) {
                    max = nums2[idx];
                }
                idx++;
            }

            if (max == nums1[i]) {
                ans[i] = -1;
            } else {
                ans[i] = max; 
            }
        }

        return ans;
    }
}