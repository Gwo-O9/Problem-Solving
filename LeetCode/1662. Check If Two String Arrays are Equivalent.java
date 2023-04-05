class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String temp1 = new String("");
        String temp2 = new String("");
        for(int i = 0; i<word1.length;i++){
            temp1 += new String(word1[i]);
        }
        for(int j = 0; j<word2.length;j++){
            temp2 += new String(word2[j]);
        }
        return temp1.equals(temp2);
    }
}
