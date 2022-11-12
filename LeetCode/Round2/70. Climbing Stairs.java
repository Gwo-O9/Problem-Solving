class Solution {
    public int climbStairs(int n) {
        int f = 1;
        int g = 2;
        for(int i = 2; i<n;i++){
            if(i%2 == 0) f += g;
            else if(i%2 == 1) g += f;
        }
        if(n%2 == 1) return f;
        else return g;
    }
}
