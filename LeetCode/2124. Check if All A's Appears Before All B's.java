class Solution {
    public boolean checkString(String s) {
        boolean power = false;
        for(int i = 0;i<s.length();i++){
            if(power == false && s.charAt(i) == 'b') power = true;
            else if(power == true && s.charAt(i) == 'a') return false;
        }
        return true;
    }
}
