class Solution {
    public String sortSentence(String s) {
        int i = 0;
        int space = 1;
        for(i = 0; i<s.length();i++){
            if(s.charAt(i) == ' ') space++;
        }
        String[] arr = new String[space];
        String temp = "";
        for(i = 0; i<s.length();i++){
            if(s.charAt(i) == ' ') continue;
            else if(s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                arr[s.charAt(i)-49] = temp;
                temp = "";
            }
            else temp += s.charAt(i);
        }
        String ans = "";
        ans = ans + arr[0];
        for(i = 1; i<arr.length;i++){
            ans = ans + " " + arr[i];
        }
        return ans;
    }
}
