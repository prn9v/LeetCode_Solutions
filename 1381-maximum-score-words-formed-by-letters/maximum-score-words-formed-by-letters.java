class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] freq = new int[26];

        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        int n = words.length;
        int maxScore = 0;

        for (int mask = 0; mask < (1 << n); mask++) {

            int[] used = new int[26];
            int subsetScore = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    for (char ch : words[i].toCharArray()) {

                        int idx = ch - 'a';
                        used[idx]++;

                        if (used[idx] > freq[idx]) {
                            valid = false;
                            break;
                        }

                        subsetScore += score[idx];
                    }
                }

                if (!valid) break;
            }

            if (valid) {
                maxScore = Math.max(maxScore, subsetScore);
            }
        }

        return maxScore;
    }
}