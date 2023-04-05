class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;
        for(int i = 0; i< m-1;i++){
            for(int j = i+1 ;j<m;j++){
                if(score[i][k] < score[j][k]){
                    for(int f = 0; f<n;f++){
                        swap(score, i, f , j);
                    }                    
                }
            }
        }
        return score;
    }

    public static void swap(int[][] arr, int i, int j, int k){
        int temp = arr[i][j];
        arr[i][j] = arr[k][j];
        arr[k][j] = temp;
    }
}
