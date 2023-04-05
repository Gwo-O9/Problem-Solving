class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        if(haystack.equals(needle)) return 0;
        for(int i = 0; i<haystack.length()-needle.length()+1;i++){
            String comp = haystack.substring(i, i + needle.length());
            if(needle.equals(comp)) return i;
        }
        return -1;
    }
}
