class Solution {
public:
    int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int arr[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int maxv = -1;
        for(int i = 2; i<= n;i++){
            helper(i, arr);
            maxv = max(arr[i], maxv);
        }
        return maxv;
    }

    void helper(int n, int arr[]){
        if(n%2 == 0){
            arr[n] = arr[(n/2)];
        } else{
            arr[n] = arr[(n/2)] + arr[(n/2) + 1];
        }
    }
};1646. Get Maximum in Generated Array
