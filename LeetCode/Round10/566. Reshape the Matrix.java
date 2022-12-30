class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length; int n = mat[0].length;
        if(m*n != r*c) return mat;
        int r2 = 0; int c2 = 0;
        int[][] ans = new int[r][c];
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                ans[r2][c2] = mat[i][j];
                c2++;
                if(c2 == c){
                    c2 = 0;
                    r2++;
                }
            }
        }
        return ans;
    }
}
