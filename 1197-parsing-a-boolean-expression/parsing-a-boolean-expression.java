class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Queue<Character>> valStack = new Stack<>();

        valStack.push(new LinkedList<>());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ',') continue;

            if (ch == '&' || ch == '|' || ch == '!') {
                stack.add(ch);
            } else if(ch == '(') {
                valStack.add(new LinkedList<>());
            } else if (ch == 'f' || ch == 't') {
                valStack.peek().add(ch);
            }else if (ch == ')') {
                Queue<Character> curr = valStack.pop();
                char sign = stack.pop();
                char result;

                if (sign == '&') {
                    result = parseAND(curr);
                } else if (sign == '|') {
                    result = parseOR(curr);
                } else {
                    result = parseNOT(curr);
                }
                valStack.peek().add(result);
            }
        }
        return valStack.peek().peek() == 't';
    }

    private char parseAND(Queue<Character> queue) {
        while (!queue.isEmpty()) {
            if (queue.poll() == 'f') {
                return 'f';
            }
        }
        return 't';
    }

    private char parseOR(Queue<Character> queue) {
        while (!queue.isEmpty()) {
            if (queue.poll() == 't') {
                return 't';
            }
        }
        return 'f';
    }

    private char parseNOT(Queue<Character> queue) {
        char val = queue.poll();
        return val == 't' ? 'f' : 't';
    }
}