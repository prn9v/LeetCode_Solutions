class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = -1;
        int end = -1;
        int i = 0,j = nums.length-1;
        while(i < nums.length){
            if(nums[i] != arr[i]){
                start = i;
                break;
            }
            i++;
        }

        if(start == -1){
            return 0;
        }

        while(j >= 0){
            if(nums[j] != arr[j]){
                end = j;
                break;
            }
            j--;
        }

        return end-start+1;
    }
}