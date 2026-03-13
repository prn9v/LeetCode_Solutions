import java.util.*;

class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer,Integer> map =  new HashMap<>();

        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }
        int ans = 0;

        for (int i = 0; i < row.length; i+=2) {
            int first = row[i];
            int second;
            if(first % 2 == 0){
                second = first+1;
            } else {
                second = first-1;
            }

            if (second != row[i+1]) {
                swap(row, i+1,map.get(second),map);
                ans++;
            }
        }

        return ans;
    }

    private void swap(int[] row, int i, int j, HashMap<Integer,Integer> map) {

        int a = row[i];
        int b = row[j];

        row[i] = b;
        row[j] = a;

        map.put(a, j);
        map.put(b, i);
    }
}