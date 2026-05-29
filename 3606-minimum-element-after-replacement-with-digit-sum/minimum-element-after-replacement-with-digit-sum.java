class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= 9){
                ans = Math.min(ans,num);
            } else {
                int sum = 0;
                while(num > 0) {
                    int digit = num % 10;
                    sum += digit;
                    num /= 10;
                }
                ans = Math.min(ans,sum);
            }
        }

        return ans;
    }
}