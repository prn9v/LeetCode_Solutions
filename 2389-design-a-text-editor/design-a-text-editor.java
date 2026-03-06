class TextEditor {
    private Stack<Character> left;
    private Stack<Character> right;

    public TextEditor() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void addText(String text) {
        char[] add = text.toCharArray();
        for (int i = 0; i < add.length; i++) {
            left.push(add[i]);
        }
    }

    public int deleteText(int k) {
        int n = Math.min(k, left.size());
        int deleted = n;
        while (n > 0) {
            left.pop();
            n--;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        int move = Math.min(k, left.size());

        while (move > 0) {
            right.push(left.pop());
            move--;
        }

        return last10();
    }

    public String cursorRight(int k) {
        int move = Math.min(k, right.size());

        while (move > 0) {
            left.push(right.pop());
            move--;
        }

        return last10();
    }

    private String last10() {
        StringBuilder sb = new StringBuilder();
        Stack<Character> temp = new Stack<>();

        int count = Math.min(10, left.size());

        for (int i = 0; i < count; i++) {
            char c = left.pop();
            temp.push(c);
        }

        while (!temp.isEmpty()) {
            char c = temp.pop();
            sb.append(c);
            left.push(c);
        }

        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */