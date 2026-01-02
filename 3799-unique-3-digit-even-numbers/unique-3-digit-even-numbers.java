import java.util.HashSet;

class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int depth = 0;
        helper(set,used,sum,depth,digits);
        return set.size();
    }

    private void helper(HashSet<Integer> set,boolean[] used,int sum,int depth,int[] digits){
        if (depth == 3) {
            if (sum % 2 == 0) {
                set.add(sum);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            if (depth == 0 && digits[i] == 0) continue;

            used[i] = true;
            helper(set, used, sum * 10 + digits[i], depth+1, digits);
            used[i] = false;
        }
    }
}
