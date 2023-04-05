class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];
        for(int i = 0;i<s.length();i++){
            sarr[s.charAt(i) - 97]++;
        }
        for(int i = 0;i<t.length();i++){
            tarr[t.charAt(i) - 97]++;
        }
        for(int i = 0; i<26;i++){
            if(sarr[i] != tarr[i]) return false;
        }
        return true;
    }
}
