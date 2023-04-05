class Solution {
    public int arrangeCoins(int n) {
        int num = n;
        for(int i = 0; i<n;i++){
            num -= i;
            if(num == 0) return i;
            else if(num <= 0) return i-1;
        }
        return 1;
    }
}
