class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(Arrays.deepEquals(mat,target)) return true;
        int n = mat.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[][] rotatemat = new int[n][n];
        for(int x = 0; x < 3; x++){
            for(j = 0; j < n; j++){
                for(k = 0; k < n; k++){
                    rotatemat[j][k] = mat[k][j];
                }
            }
            for(i = 0; i < n; i++){
                int left = 0;
                int right = n-1;
                while(left < right){
                    int temp = rotatemat[i][left];
                    rotatemat[i][left] = rotatemat[i][right];
                    rotatemat[i][right] = temp;
                    left++;
                    right--;
                }
            }
            if(Arrays.deepEquals(rotatemat,target)) return true;
            for(i = 0; i < n; i++){
                for(j = 0; j < n; j++){
                    mat[i][j] = rotatemat[i][j];
                }
            }
        }
        return false;
    }
}
