class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.sort(deck);
        queue.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            queue.addFirst(queue.removeLast());
            queue.addFirst(deck[i]);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            deck[i] = queue.removeFirst();
            i++; 
        }

        return deck;
    }
}