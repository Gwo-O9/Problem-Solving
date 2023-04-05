class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alp = new int[26];
        for(int i = 0; i<sentence.length();i++){
            alp[(int)sentence.charAt(i) - 97]++;
        }
        for(int j = 0; j<26;j++){
            if(alp[j] == 0) return false;
        }
        return true;
    }
}
