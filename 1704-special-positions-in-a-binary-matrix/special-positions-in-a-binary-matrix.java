class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    boolean valid = true;

                    for(int k = 0; k < mat.length; k++){
                        if(k != i && mat[k][j] != 0){
                            valid = false;
                            break;
                        }
                    }

                    for(int k = 0; k < mat[0].length; k++){
                        if(k != j && mat[i][k] != 0){
                            valid = false;
                            break;
                        }
                    }

                    if(valid){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}