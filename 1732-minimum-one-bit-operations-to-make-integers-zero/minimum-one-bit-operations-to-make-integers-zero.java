class Solution {
    public int minimumOneBitOperations(int n) {
        Stack<Integer> stack = new Stack<>();
        int num = n;
        
        int i = 1;
        while(num != 0){
            if((num & 1) == 1){
                stack.push((int)(Math.pow(2,i)-1));
            }
            i++;
            num = num >> 1;
        }

        int ans = 0;
        boolean add = true;
        while(!stack.isEmpty()){
            if(add){
                ans += stack.pop();
            } else {
                ans -= stack.pop();
            }
            add = !add;
        }

        return ans;
    }
}