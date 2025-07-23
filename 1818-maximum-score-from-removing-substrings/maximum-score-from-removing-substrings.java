class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return helper(s, "ab", x, y);
        } else {
            return helper(s, "ba", y, x);
        }
    }

    private int helper(String s, String first, int firstVal, int secondVal) {
        int score = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && ch == first.charAt(1)) {
                stack.pop();
                score += firstVal;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }

        Stack<Character> secondStack = new Stack<>();
        for (int i = remaining.length() - 1; i >= 0; i--) {
            char ch = remaining.charAt(i);
            if (!secondStack.isEmpty() && secondStack.peek() == first.charAt(1) && ch == first.charAt(0)) {
                secondStack.pop();
                score += secondVal;
            } else {
                secondStack.push(ch);
            }
        }

        return score;
    }
}
