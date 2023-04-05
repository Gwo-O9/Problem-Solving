class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNotech = new int[26];
        int[] magazinech = new int[26];
        for(int i = 0; i<magazine.length();i++){
            magazinech[magazine.charAt(i) - 97]++;
        }
        for(int j = 0; j<ransomNote.length();j++){
            ransomNotech[ransomNote.charAt(j) - 97]++;
        }
        for(int k = 0; k<26;k++){
            if(ransomNotech[k] > magazinech[k]) return false;
        }
        return true; 
    }
}
