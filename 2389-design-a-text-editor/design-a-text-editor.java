class TextEditor {
    public StringBuilder prefix;
    public Stack<Character> suffix;

    public TextEditor() {
        prefix = new StringBuilder();
        suffix = new Stack();
    }
    
    public void addText(String text) {
        prefix.append(text);
    }
    
    public int deleteText(int k) {
        if (k > prefix.length()) k = prefix.length();
        prefix.setLength(prefix.length() - k);
        return k;
    }
    
    public String cursorLeft(int k) {
        if (k > prefix.length()) k = prefix.length();
        for (int i = 0; i < k; i ++) suffix.push(prefix.charAt(prefix.length() - 1 - i));
        prefix.setLength(prefix.length() - k);
        return prefix.length() >= 10 ? prefix.substring(prefix.length() - 10, prefix.length()) : prefix.toString();
    }
    
    public String cursorRight(int k) {
        if (k > suffix.size()) k = suffix.size();
        for (int i = 0; i < k; i ++) prefix.append(suffix.pop());
        return prefix.length() >= 10 ? prefix.substring(prefix.length() - 10, prefix.length()) : prefix.toString();
    }
}