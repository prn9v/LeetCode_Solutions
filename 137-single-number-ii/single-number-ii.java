class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum ^= num;
        }
        HashSet<Integer> ones = new HashSet<>();
        HashSet<Integer> twos = new HashSet<>();

        for(int num : nums) {
            if(ones.contains(num)){
                if(!twos.contains(num)) {
                    twos.add(num);
                } else {
                    sum ^= num;
                }
            } else {
                ones.add(num);
            }
        }

        return sum;
    }
}