class Solution {
    public String restoreString(String s, int[] indices) {
        //if(s.equals("codeleet")) return "leetcode";
        char[] temp = new char[s.length()];
        String ans = new String("");
        for(int i = 0; i<s.length();i++){
            temp[indices[i]] = s.charAt(i); 
        }
        return new String(temp);
    }
}
