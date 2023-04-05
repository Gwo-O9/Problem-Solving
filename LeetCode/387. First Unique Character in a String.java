class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0; i<s.length();i++){
            count[(int) s.charAt(i) - 97]++;
        }
        for(int j = 0;j<s.length();j++){
            if(count[(int) s.charAt(j) - 97] == 1) return j;
        }
        return -1;
    }
}
