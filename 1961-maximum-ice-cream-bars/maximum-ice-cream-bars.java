class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Step 1: Find the maximum cost to determine the range for counting sort
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        // Step 2: Create a frequency array for all possible costs
        int[] freq = new int[maxCost + 1];
        for (int cost : costs) {
            freq[cost]++;
        }

        int iceCreamCount = 0;
        // Step 3: Iterate through costs from cheapest to most expensive
        for (int cost = 1; cost <= maxCost; cost++) {
            if (freq[cost] == 0) continue;

            // If we can't even afford one of this price, we are done
            if (coins < cost) break;

            // Calculate how many bars of this price we can afford
            // We can take either all available bars of this price OR 
            // only as many as our coins allow.
            int canBuy = Math.min(freq[cost], coins / cost);
            
            iceCreamCount += canBuy;
            coins -= (canBuy * cost);
        }

        return iceCreamCount;
    }
}