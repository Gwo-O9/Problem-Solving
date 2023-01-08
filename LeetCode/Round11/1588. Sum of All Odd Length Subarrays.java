class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int count = 0;
        int n = arr.length;
        int i,j,k;
        for(i = 1; i<=n;i +=2){
            for(j = 0; j<=n-i;j++){
                for(k = 0;k<i;k++){
                    count += arr[j+k];
                }
            }
        }
        return count;
    }
}
