class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;

            if (used[ch - 'a']) continue;

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {
                used[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            used[ch - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}