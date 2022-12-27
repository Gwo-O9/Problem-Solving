class Solution {
    public char findTheDifference(String s, String t) {
        List<Character> arr = new ArrayList<Character>();
        for(int i = 0; i<s.length();i++){
            arr.add(s.charAt(i));
        }
        for(int j = 0; j<t.length();j++){
            if(!arr.contains(t.charAt(j))) return t.charAt(j);
            else arr.remove(arr.indexOf(t.charAt(j)));
        }
        return 't';
    }
}
