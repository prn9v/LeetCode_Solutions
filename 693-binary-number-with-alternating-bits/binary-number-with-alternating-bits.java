class Solution {
    public boolean hasAlternatingBits(int n) {
        int setBit;
        if(n % 2 == 0){
            setBit = 0;
        } else {
            setBit = 1;
        }

        while(n != 0){
            int bit = n & 1;
            if(bit != setBit) {
                return false;
            }
            setBit = (setBit == 1) ? 0 : 1;
            n = n >> 1;
        }

        return true;
    }
}