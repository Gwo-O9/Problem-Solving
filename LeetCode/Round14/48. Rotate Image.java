class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[][] rotatemat = new int[n][n];
        for(j = 0; j < n; j++){
            for(k = 0; k < n; k++){
                rotatemat[j][k] = matrix[k][j];
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
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                matrix[i][j] = rotatemat[i][j];
            }
        }
    }
}
