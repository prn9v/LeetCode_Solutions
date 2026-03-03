public class Solution {

    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        return helper(str,n,k,1);
    }

    private char helper(StringBuilder str,int n, int k,int index){
        if(index == n){
            return str.charAt(k-1);
        }

        int len = str.length();
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < len; i++){
            newStr.append(str.charAt(i) == '0' ? '1' : '0');
        }

        newStr.reverse();
        str.append('1');           
        str.append(newStr);

        return helper(str,n,k,index+1);
    }
}