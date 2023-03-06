class Solution {
public:
    int tribonacci(int n) {
        int f = 0;
        int g = 1;
        int k = 1;
        int t;
        int i = 3;
        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;
        else{
            while(i<=n){
                t = f + g + k;
                f = g;
                g = k;
                k = t;
                i++;
            }
        }
        return t;
    }
};
