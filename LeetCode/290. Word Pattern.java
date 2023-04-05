class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if(array.length != pattern.length()) return false;
        for(int i = 0; i<pattern.length();i++){
            for(int j = i+1;j<pattern.length();j++){
                if(pattern.charAt(i) != pattern.charAt(j) && array[i].equals(array[j])) return false;
                if(pattern.charAt(i) == pattern.charAt(j) && !array[i].equals(array[j])) return false;
            }
        }
        return true;
    }
}
