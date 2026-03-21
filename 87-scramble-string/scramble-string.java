import java.util.*;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        HashMap<String, Boolean> map = new HashMap<>();
        return helper(map, s1, s2);
    }

    private boolean helper(HashMap<String,Boolean> map, String a, String b) {
        if (a.equals(b)) {
            return true;
        }

        if(a.length() == 1) {
            return false;
        }

        StringBuilder str = new StringBuilder();
        String temp = str.append(a).append("#").append(b).toString();
        if(map.containsKey(temp)) {
            return map.get(temp);
        }

        int n = a.length();
        boolean flag = false;

        for(int i = 1; i < n; i++) {
            if( ( ( helper(map,a.substring(0,i),b.substring(n-i,n) ) ) && helper(map,a.substring(i,n),b.substring(0,n-i) ) )  || ( helper(map,a.substring(0,i), b.substring(0,i)) && helper(map,a.substring(i,n), b.substring(i,n)) ) ) {
                flag = true;
                break;
            }
        }

        map.put(temp,flag);
        return flag;
    }
}