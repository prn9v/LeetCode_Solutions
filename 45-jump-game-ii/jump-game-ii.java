class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[nums.length];
        int count = 0;
        queue.add(0);
        vis[0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {

                int idx = queue.poll();

                if (idx == nums.length - 1)
                    return count;

                for (int j = 1; j <= nums[idx] && idx + j < nums.length; j++) {
                    if (!vis[idx + j]) {
                        vis[idx + j] = true;
                        queue.offer(idx + j);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}