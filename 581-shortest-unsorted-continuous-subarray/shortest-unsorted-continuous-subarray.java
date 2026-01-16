class Solution {
    public int findUnsortedSubarray(int[] nums) {
       int count=-1,count2=-1,min=nums[nums.length-1],max=nums[0];
       for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max)count=i;
       }
       if(count==-1)return 0;
       for(int i=nums.length-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min)count2=i;
       } 
       return count-count2+1;
    }
}