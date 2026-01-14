import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sum = num2 + num1;
                stack.push(sum);
            } else if (str.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sub = num1 - num2;
                stack.push(sub);
            } else if (str.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int prod = num1 * num2;
                stack.push(prod);
            } else if (str.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                 int div = num1 / num2;
                stack.push(div);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}