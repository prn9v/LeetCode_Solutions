class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();

        for(String b : bank) {
            set.add(b);
        }

        if(!set.contains(endGene)){
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        char[] choices = {'A', 'C', 'G', 'T'};

        queue.add(startGene);

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String s = queue.poll();

                if (s.equals(endGene)) {
                    return count;
                }

                for(int i = s.length() - 1; i >= 0; i--) {
                    char[] arr = s.toCharArray();

                    for (char ch : choices) {
                        if (ch == arr[i]) continue;

                        arr[i] = ch;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            queue.add(next);
                            set.remove(next); 
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }
}