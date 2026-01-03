class Solution {
    public char kthCharacter(int k) {
        int shift = 0;
        int length = 1;

        while (length < k) {
            length <<= 1;
        }

        while (length > 1) {
            int half = length >> 1;

            if (k > half) {
                k -= half;
                shift++;
            }

            length = half;
        }

        return (char)('a'+shift);
    }
}