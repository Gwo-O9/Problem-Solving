class Solution {
    public String reverseWords(String s) {
        String ans = new String("");
        String temp = new String("");
        for(int i = s.length()-1; i>=0;i--){
            if(i == 0){
                temp = temp + s.charAt(i);
                ans =  temp + " " + ans;
                continue;
            }
            else if(s.charAt(i) == ' '){
                ans =  temp + " " + ans;
                temp = "";
                continue;
            }
            else temp = temp + s.charAt(i);
        }
        ans = ans.substring(0, ans.length() -1);
        return ans;
    }
}
