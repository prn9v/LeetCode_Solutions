import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        List<Integer> leftResult;
        List<Integer> rightResult;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                leftResult = diffWaysToCompute(expression.substring(0, i));
                rightResult = diffWaysToCompute(expression.substring(i + 1));

                for (int j = 0; j < leftResult.size(); j++) {
                    int left = leftResult.get(j);
                    for (int k = 0; k < rightResult.size(); k++) {
                        int right = rightResult.get(k);
                        if (ch == '+') {
                            list.add(left + right);
                        } else if (ch == '-') {
                            list.add(left - right);
                        } else {
                            list.add(left * right);
                        }
                    }
                }
            }
        }

        if (list.isEmpty()) {
            list.add(Integer.parseInt(expression));
        }

        return list;
    }
}