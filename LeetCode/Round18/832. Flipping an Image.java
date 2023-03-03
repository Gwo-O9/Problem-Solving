class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i = 0; i<n;i++){
            if(n%2 == 1) image[i][n/2] = image[i][n/2] == 0 ? 1 : 0;
            for(int j = 0; j<n/2;j++){
                int left = image[i][j];
                int right = image[i][n-1-j];
                image[i][j] = right == 0 ? 1 : 0;
                image[i][n-1-j] = left == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
