
class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for (String num : nums) {
            int integerNum = convertToInteger(num);
            set.add(integerNum);
        }

        for (int i = 0; i < (1 << n); i++) {
            if (!set.contains(i)) {
                return convertToBinary(i, n);
            }
        }

        return "";
    }

    private int convertToInteger(String s) {
        return Integer.parseInt(s, 2);
    }

    private String convertToBinary(int num, int n) {
        String binary = Integer.toBinaryString(num);

        while (binary.length() < n) {
            binary = "0" + binary;
        }

        return binary;
    }
}