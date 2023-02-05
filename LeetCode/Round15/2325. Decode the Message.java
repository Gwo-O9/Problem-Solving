class Solution {
    public String decodeMessage(String key, String message) {
        key = key.replaceAll(" ","");
        String ans = "";
        int i;
        int j = 0;
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        for (i = 0; i < key.length(); i++) {
            if (!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i),(char)('a' + j));
                j++;
            }
        }
        for (i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') ans += " ";
            else {
                ans += map.get(message.charAt(i));
            }
        }
        return ans;
    }
}
