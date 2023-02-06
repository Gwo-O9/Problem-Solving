class Solution {
    public String truncateSentence(String s, int k) {
        int space = 1;
        String ans = "";
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == ' ') space++;
            if(space == k+1) break;
            ans += s.charAt(i);
        }
        return ans;
    }
}
