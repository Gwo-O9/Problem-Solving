class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = new String("");
        int i = 0; 
        int j = 0;
        while(i < word1.length() && j < word2.length()){
            ans += Character.toString(word1.charAt(i));
            ans += Character.toString(word2.charAt(j));
            i++; j++;
        }
        if(i<word1.length()){
            while(i<word1.length()){
                ans += Character.toString(word1.charAt(i));
                i++;
            }
        }
        else if(j< word2.length()){
            while(j<word2.length()){
                ans += Character.toString(word2.charAt(j));
                j++;
            }
        }
        return ans;
    }
}
