class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = nums1.clone();
        int l = 0, i = 0, j = 0;

        while(i < m || j < n) {
            if((i < m && j < n) && temp[i] <= nums2[j]) {
                nums1[l++] = temp[i++];
            }
            else if((i < m && j < n) && temp[i] > nums2[j]) {
                nums1[l++] = nums2[j++];
            }
            else if(i < m){
                nums1[l++] = temp[i++];
            }
            else{
                nums1[l++] = nums2[j++];
            }
        }
    }
}