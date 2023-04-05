class Solution {
    public boolean isPalindrome(int x) {
        String x2 = String.valueOf(x);
        
        int n = x2.length();
        
        int i = 0;
        while(i<n){
            if(x2.charAt(i) == x2.charAt(n-1)){
                i++;
                n--;
            }
            else return false;
        }
        return true;
    }
}
