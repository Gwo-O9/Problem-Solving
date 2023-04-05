class Solution {
    public int diagonalSum(int[][] mat) {
        int count = 0;
        int i,j;
        for(i = 0,j = 0; i<mat.length;i++,j++){
            count += mat[i][j];
        }
        for(i = mat.length-1, j =0; i>= 0;i--,j++){
            count += mat[i][j];
        }
        if(mat.length%2 == 1) count -= mat[mat.length/2][mat.length/2];
        return count;
    }
}
