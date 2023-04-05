class Solution {
    public int fib(int n) {
        int f = 0;
        int g = 1;
        for(int i = 2; i<=n;i++){
            if(i%2 == 0) f += g;
            if(i%2 == 0) g += f;
        }
        if(n%2 == 0) return f;
        else return g;
    }
}
