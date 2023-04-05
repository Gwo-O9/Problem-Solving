class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        for(int i = 1; i<n;i++){
            int sum1 = 0;
            int sum2 = 0;
            for(int j = 1; j<=i;j++){
                sum1 += j;
            }
            for(int k = i;k<=n;k++){
                sum2 += k;
            }
            if(sum1 == sum2) return i;
        }
        return -1;
    }
}

//under is faster and more mathematical code
class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n+1) /2;
        int leftsum = 0;
        
        for(int i = 1;i <= n;i++){
            leftsum += i;
            if(leftsum == sum - leftsum + i) return i;
        }
        return -1;
    }
}
