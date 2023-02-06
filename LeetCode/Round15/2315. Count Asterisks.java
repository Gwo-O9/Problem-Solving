class Solution {
    public int countAsterisks(String s) {
        boolean power = true;
        int cnt = 0;
        for(int i = 0; i<s.length();i++){
            if(power == true && s.charAt(i) == '*') cnt++;
            if(power == false && s.charAt(i) == '|') power = true;
            else if(power == true && s.charAt(i) == '|') power = false;
        }
        return cnt;
    }
}
