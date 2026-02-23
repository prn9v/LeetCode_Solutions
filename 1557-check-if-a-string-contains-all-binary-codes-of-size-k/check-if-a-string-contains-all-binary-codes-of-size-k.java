class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String binaryNum = s.substring(i, i+k);
            set.add(binaryNum);
        }

        if (set.size() == Math.pow(2, k)) {
            return true;
        } else {
            return false;
        }
    }
}