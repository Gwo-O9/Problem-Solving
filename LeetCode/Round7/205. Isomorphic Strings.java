class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map map = new HashMap();
        for(Integer i = 0;i<s.length();i++){
            if(map.put(s.charAt(i),i) != map.put(t.charAt(i)+150,i)) return false; //+150 is used for differentiate char of string s and string t. (to use unique map)
        }
        return true;
    }
}
