class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        String ischecked = new String("");
        int cnt = 0;
        for(int i = 0;i<len-1;i++){
            if(ischecked.contains(String.valueOf(s.charAt(i)))) continue;
            int k = 1;
            for(int j = i+1;j<len;j++){
                if(s.charAt(i) == s.charAt(j)) k++;
                else continue;
            }
            cnt += k%2 == 0? k : k-1;
            ischecked += String.valueOf(s.charAt(i));
        }
        return cnt == len ? cnt : cnt+1;
    }
}
