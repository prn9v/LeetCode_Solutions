class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merged sorted array
        int[] merged = sort(nums1, nums2);

        // Calculate median
        if (merged.length % 2 != 0) {
            int mid = merged.length / 2;
            return merged[mid];
        } else {
            int mid1 = merged.length / 2;
            int mid2 = mid1 - 1;
            return (merged[mid1] + merged[mid2]) / 2.0;  
        }
    }

    // Helper function to merge and sort the arrays
    public int[] sort(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        
        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of first array
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements of second array
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
