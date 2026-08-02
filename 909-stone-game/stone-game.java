class Solution {
    public boolean stoneGame(int[] piles) {
        return helper(piles,0,piles.length-1,0,0,true);
    }

    private boolean helper(int[] piles, int i, int j, int sum1, int sum2, boolean isPlayerOne) {
        if(i > j) {
            if(sum1 > sum2) {
                return true;
            }

            return false;
        }

        if(isPlayerOne){
            if(piles[i] >= piles[j]) {
                return helper(piles,i+1,j,sum1+piles[i],sum2,false);
            } else {
                return helper(piles,i,j-1,sum1+piles[j],sum2,false);
            }
        } else {
            if(piles[i] >= piles[j]) {
                return helper(piles,i,j-1,sum1,sum2+piles[j],true);
            } else {
                return helper(piles,i+1,j,sum1,sum2+piles[i],true);
            }
        }
    }
}