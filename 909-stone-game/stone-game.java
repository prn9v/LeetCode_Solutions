class Solution {
    public boolean stoneGame(int[] piles) {
        HashMap<String,Boolean> map = new HashMap<>();
        return helper(map,piles,0,piles.length-1,0,0,true);
    }

    private boolean helper(HashMap<String,Boolean> map, int[] piles, int i, int j, int sum1, int sum2, boolean isPlayerOne) {
        if(i > j) {
            if(sum1 > sum2) {
                return true;
            }

            return false;
        }

        String key = i + "_" + j + "_" + sum1 + "_" + sum2 + "_" + isPlayerOne;
        if(map.containsKey(key)){
            return map.get(key);
        }

        if(isPlayerOne){
            if(piles[i] >= piles[j]) {
                boolean val = helper(map,piles,i+1,j,sum1+piles[i],sum2,false);
                map.put(key,val);
                return val;
            } else {
                boolean val = helper(map,piles,i,j-1,sum1+piles[j],sum2,false);
                map.put(key,val);
                return val;
            }
        } else {
            if(piles[i] >= piles[j]) {
                boolean val = helper(map,piles,i,j-1,sum1,sum2+piles[j],true);
                map.put(key,val);
                return val;
            } else {
                boolean val = helper(map,piles,i+1,j,sum1,sum2+piles[i],true);
                map.put(key,val);
                return val;
            }
        }
    }
}