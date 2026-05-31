class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int letters = 0;
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {
                letters += words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k != j - 1)
                        sb.append(' ');
                }

                while (sb.length() < maxWidth)
                    sb.append(' ');
            }
            else {
                int totalSpaces = maxWidth - letters;
                int base = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        int spaces = base;

                        if (extra > 0) {
                            spaces++;
                            extra--;
                        }

                        for (int s = 0; s < spaces; s++)
                            sb.append(' ');
                    }
                }
            }
            res.add(sb.toString());
            i = j;
        }

        return res;
    }
}