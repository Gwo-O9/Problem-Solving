class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i,j;
        int cnt = 0;
        for(i = 0; i< n1; i++){
            for(j = 0; j< n2;j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    cnt++;
                    break;
                }
            }
        }
        return n1-cnt;
    }
}
