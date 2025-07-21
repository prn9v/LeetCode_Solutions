class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        char last = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == last && count != 2){
                ans.append(s.charAt(i));
                count++;
            } else if(s.charAt(i) != last){
                count = 1;
                ans.append(s.charAt(i));
                last = s.charAt(i);
            }else{
                continue;
            }
        }

        return ans.toString();
    }
}