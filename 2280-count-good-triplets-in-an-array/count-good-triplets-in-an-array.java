class Solution {

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            i++;
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            i++;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pos[nums1[i]];
        }

        Fenwick leftTree = new Fenwick(n);
        Fenwick rightTree = new Fenwick(n);

        for (int x : arr) {
            rightTree.update(x, 1);
        }

        long ans = 0;

        for (int x : arr) {

            rightTree.update(x, -1);

            long leftCount = leftTree.query(x - 1);
            long rightCount = rightTree.query(n - 1) - rightTree.query(x);

            ans += leftCount * rightCount;

            leftTree.update(x, 1);
        }

        return ans;
    }
}