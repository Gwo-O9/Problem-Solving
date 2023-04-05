class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        helper(s,ans,"",0);
        return ans;
    }
    public void helper(String s, List<String> ans, String temp, int i){
        if(i == s.length()){
            ans.add(temp);
            return;
        }
        char ch = s.charAt(i);
        if(Character.isDigit(ch)){
            helper(s,ans,temp + ch, i+1);
        }
        else{
            helper(s,ans,temp + Character.toUpperCase(ch), i+1);
            helper(s,ans,temp + Character.toLowerCase(ch), i+1);
        }
    }
}
