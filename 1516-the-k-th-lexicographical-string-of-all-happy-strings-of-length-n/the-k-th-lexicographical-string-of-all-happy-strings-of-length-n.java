class Solution {
    public String getHappyString(int n, int k) {
        if(k > 3 * Math.pow(2,n-1)) {
            return "";
        }

        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(list,n,k,str);
        return list.get(k-1);
    }

    private void helper(List<String> list,int n,int k,StringBuilder str) {
        if (str.length() == n) {
            list.add(str.toString());
            return;
        }

        int len = str.length();

        for (char i = 'a'; i <= 'c'; i++) {
            if(len > 0 && str.charAt(len-1) == i){
                continue;
            }
            str.append(i);
            helper(list, n, k, str);
            str.setLength(len);
        }
    }
}