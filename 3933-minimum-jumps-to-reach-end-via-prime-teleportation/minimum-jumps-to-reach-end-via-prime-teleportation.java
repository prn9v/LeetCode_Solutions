class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        int MAX = 1000000;

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = nums[i];

            for(int p = 2; p*p <= val; p++) {
                if(val % p == 0) {
                    if(isPrime[p]) {
                        map.computeIfAbsent(p,k -> new ArrayList<>()).add(i);
                    }
                }

                while(val % p == 0){
                    val/=p;
                }

            }

            if(val > 1) {
                map.computeIfAbsent(val,k -> new ArrayList()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int steps = 0;

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int q = queue.poll();

                if(q == n-1){
                    return steps;
                }

                if(q-1 >= 0 && !visited[q-1]) {
                    visited[q-1] = true;
                    queue.add(q-1);
                }

                if(q+1 < n && !visited[q+1]) {
                    visited[q+1] = true;
                    queue.add(q+1);
                }

                int val = nums[q];

                if(isPrime[val] && map.containsKey(val)) {

                    for(int next : map.get(val)) {

                        if(!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }

                    map.remove(val);
                }
            }
            steps++;
        }

        return -1;
    }
}