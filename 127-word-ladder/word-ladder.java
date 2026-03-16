import java.util.*;

class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int length = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String current = q.poll();
                char[] temp = current.toCharArray();

                for (int j = 0; j < temp.length; j++) {

                    char original = temp[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        temp[j] = c;
                        String newWord = new String(temp);

                        if (newWord.equals(endWord))
                            return length + 1;

                        if (c != original && wordSet.contains(newWord)) {
                            q.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    temp[j] = original;
                }
            }

            length++;
        }

        return 0;
    }
}