class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(temperatures[i] < temperatures[j]) {
                    ans[i] = j-i;
                    break;
                }
                if(i > 1 && temperatures[i] == temperatures[i-1]){
                    if(ans[i-1] == 0) ans[i] = 0;
                    else ans[i] = ans[i-1] -1;
                    break;
                }
            }
        }
        return ans;
    }
}
