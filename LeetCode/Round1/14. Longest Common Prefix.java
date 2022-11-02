class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String result = new String("");
        
        if(n == 0) return "";
        if(n == 1){
            return strs[0];
        }
        
        Arrays.sort(strs);
        for(int i = 0; i<strs[0].length();i++){
            if(strs[0].charAt(i) == strs[n-1].charAt(i)) result += strs[0].charAt(i);
            else return result;
        }
        return result;
    }
}
