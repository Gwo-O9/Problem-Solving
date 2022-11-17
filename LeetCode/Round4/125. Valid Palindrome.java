class Solution {
    public boolean isPalindrome(String s) {
        String x = new String("");
        for(int i = 0; i<s.length();i++){
            if(('a' <= s.charAt(i) && s.charAt(i) <= 'z') || ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') || ('0' <= s.charAt(i) && s.charAt(i) <= '9')){
                x += s.charAt(i);
            }
            else continue;
        }
        x = x.toLowerCase();
        return helper(x);
    }
    
      public boolean helper(String x) {
        int n = x.length()-1;
        
        int i = 0;
        while(i<n){
            if(x.charAt(i) == x.charAt(n)){
                i++;
                n--;
            }
            else return false;
        }
        return true;
    }
}
