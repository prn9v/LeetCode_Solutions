class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] arr = s2.toCharArray();

        for(int i = 0; i < 2; i++) {

            if(s1.charAt(i) != arr[i]){
                char ch = arr[i+2];
                arr[i+2] = arr[i];
                arr[i] = ch;
            }

        }

        String str = new String(arr);
        if(str.equals(s1)) {
            return true;
        } else {
            return false;
        }
    }
}