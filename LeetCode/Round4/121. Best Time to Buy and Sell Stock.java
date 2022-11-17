class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i<n-1;i++){
            if(min>prices[i]){
                min = prices[i];
                for(int j = i;j<n;j++){
                    if(prices[j]-min > max) max = prices[j]-min; 
                }
            }
        }
        return max;
    }
}
