class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 1) return ans;

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < n - 1; i++) {
            minDiff = Math.min(minDiff,arr[i + 1] - arr[i]);
        }

        for(int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minDiff) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }
        
        return ans;
    }
}