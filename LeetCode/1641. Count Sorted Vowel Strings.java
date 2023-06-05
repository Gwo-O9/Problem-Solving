class Solution {
    public int countVowelStrings(int n) {
        int a = 1, b = 1, c = 1, d = 1, e = 1;
        for(int i = 1; i<n; i++){
            d = d + e;
            c = c + d;
            b = b + c;
            a = a + b;
        }
        return a + b + c + d + e;
    }
}
