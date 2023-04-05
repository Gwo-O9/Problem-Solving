class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int j = 0; j<=n;j++){
            int num = j;
            int count = 0;
            for(int i = (int) Math.sqrt(n)+1; i>=0;i--){
                if(Math.pow(2,i) <= num){
                    count++;
                    num -= Math.pow(2,i);
                }
            }
            ans[j] = count;
        }
        return ans;   
    }
}
