class Solution {
    public int shortestSequence(int[] rolls, int k) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for(int roll: rolls){
            set.add(roll);
            if(set.size() == k){
                set.clear();
                ans++;
            }
        }

        return ans+1;
    }
}