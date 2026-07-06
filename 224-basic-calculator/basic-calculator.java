class Solution {
    public int calculate(String s) {
        String exp = "("+s+")";
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        int sign = 1;

        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == ' '){
                continue;
            } else if(ch == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if(ch == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                num = 0;
            } else if(ch == ')') {
                result += sign * num;
                num = 0;

                if(!stack.isEmpty()){
                    result *= stack.pop();
                    result += stack.pop();
                }
            } else {
                num = (num * 10) + (ch - '0');
            }
        }

        return result;
    }
}