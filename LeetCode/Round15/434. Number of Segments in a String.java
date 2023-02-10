class Solution {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) != ' '){
                ans++;
                while(s.charAt(i) != ' '){
                    i++;
                    if(i == s.length()) break;
                }
            }
        }
        return ans;
    }
}
