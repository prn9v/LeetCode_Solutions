import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            }

            else if (Character.isAlphabetic(ch)) {
                curr.append(ch);
            }

            else if (ch == '[') {
                countStack.push(count);
                stringStack.push(curr);
                curr = new StringBuilder();
                count = 0;
            }

            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                StringBuilder expanded = new StringBuilder();
                for (int r = 0; r < repeat; r++) {
                    expanded.append(curr);
                }
                curr = prev.append(expanded);
            }
        }

        return curr.toString();
    }
}
