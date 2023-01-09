class Solution {
    public String freqAlphabets(String s) {
        char[] temp = s.toCharArray();
        String ans = new String("");
        for(int i =temp.length-1;i>=0;i--){
            int num = 0;
            if(temp[i] == '#'){
                num = temp[i-1]-48 + (temp[i-2]-48)*10;
                ans = (char) (num+96) + ans;
                i -= 2;
            }
            else{
                ans = ((char)((temp[i]-48)+96)) + ans;
            }
        }
        return ans;
    }
}
