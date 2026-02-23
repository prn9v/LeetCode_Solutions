class FreqStack {
    class Pair {
        int data;
        int count;
        int index;

        Pair(int data) {
            this.data = data;
            this.count = 1;
        }

        Pair(int data, int count) {
            this.data = data;
            this.count = count;
        }

        Pair(int data, int count, int index) {
            this.data = data;
            this.count = count;
            this.index = index;
        }
    }

    private PriorityQueue<Pair> queue;
    private Map<Integer, Integer> freq;
    private int index;

    public FreqStack() {
        index = 0;
        freq = new HashMap<>();
        queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a.count == b.count)
                        return b.index - a.index;
                    return b.count - a.count;
                });
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        queue.offer(new Pair(val, f, index++));
    }

    public int pop() {
        Pair top = queue.poll();
        int val = top.data;

        freq.put(val, freq.get(val) - 1);

        return val;
    }
}