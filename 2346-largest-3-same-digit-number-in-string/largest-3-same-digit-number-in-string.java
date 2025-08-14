class Solution {
    public String largestGoodInteger(String num) {
        int maxAns = -1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 1; i < num.length(); i++){
            if(num.charAt(i) == num.charAt(i-1)){
                count++;
            } else {
                count = 0;
            }

            if(count == 2){
                int n = num.charAt(i) - '0'; 
                maxAns = Math.max(maxAns,n);
            }
        }

        if (maxAns == -1) return "";

        for(int i = 0; i < 3; i++){
            sb.append(Integer.toString(maxAns));
        }

        return sb.toString();
    }
}