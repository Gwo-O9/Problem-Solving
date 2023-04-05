class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashSet set = new HashSet<Character>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int i = 0;i<s.length();i++){
            while(left <= i && set.contains(s.charAt(i))){    
                set.remove(s.charAt(left));
                left++;
            }
                set.add(s.charAt(i));
                max = Math.max(max, i-left+1);
        }
        return max;
    }
}
