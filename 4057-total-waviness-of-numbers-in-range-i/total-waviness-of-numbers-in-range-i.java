class Solution {
    public int solve(int el){
        int count = 0;

        String s = String.valueOf(el);

        for(int i = 1; i < s.length() - 1; i++){
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            int next = s.charAt(i + 1) - '0';

            if(curr > prev && curr > next || (curr < prev && curr < next)){
                count++;
            }
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int start = Math.max(100, num1);
        int res = 0;

        for(int i = start; i <= num2; i++){
            res += solve(i);
        }

        return res;
    }
}