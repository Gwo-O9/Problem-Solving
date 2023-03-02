 class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 1) return 1;
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i<n){
            int count = 1;
            while(i<n-1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            chars[j++] = chars[i++];
            if(count > 1){
                String cnt = String.valueOf(count);
                for(int c = 0; c<cnt.length();c++){
                    chars[j++] = cnt.charAt(c);
                }
            }
        }
        return j;
    }
}
