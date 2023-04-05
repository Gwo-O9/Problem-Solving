class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] bit = new int[n];
        int i = 0; 
        int j = 0;
        int[] tp = new int[n];
        for(i = 0;i<n;i++){
            tp[i] = arr[i];
        }
        for(j = 0; j<n;j++){
        int sum = 0;
            for(i = 0;i<=31;i++){
                int temp = tp[j] & 1;
                if(temp != 0) sum++;
                tp[j] >>= 1;
            }
            bit[j] = sum;
        }
        int tmp = 0;
        for(i=0; i < n; i++){
            for(j=1; j < (n-i); j++){
                if(bit[j-1] > bit[j]){
                    tmp = bit[j-1];
                    bit[j-1] = bit[j];
                    bit[j] = tmp;
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                else if(bit[j-1] == bit[j] && arr[j-1] > arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
