class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        int maxScore = 0;
        queue.add(nums[0]);
        set.add(nums[0]);
        int score = nums[0];

        for(int i = 1; i < nums.length; i++){
            if (!set.contains(nums[i])){
                score += nums[i];
                queue.add(nums[i]);
                set.add(nums[i]);
            } else {
                while(nums[i] != queue.peek()){
                    int num = queue.remove();
                    score -= num;
                    set.remove(num);
                }
                queue.remove();
                queue.add(nums[i]);
            }

            maxScore = Math.max(score,maxScore);
        }

       maxScore = Math.max(score,maxScore);

        return maxScore;
    }
}