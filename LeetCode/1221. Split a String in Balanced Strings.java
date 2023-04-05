class Solution {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int sum = 0;
        int lc = 0;
        int rc = 0;
        for(int i = 0; i<n;i++){
            if(lc != 0 && rc != 0 && lc == rc){
                sum++;
                lc = 0;
                rc = 0;
            }
            if(s.charAt(i) == 'L') lc++;
            else rc++; 
        }
        return sum+1;
    }
}
