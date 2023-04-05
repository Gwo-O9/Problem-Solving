class Solution {
    public String addBinary(String a, String b) {
        String out = new String("");
        int upindex= 0;
        
        int i = 0;
        while(i< a.length() || i< b.length() || upindex != 0){
            int aindex = 0;
            if(i<a.length() && a.charAt(a.length()-i-1) == '1'){
                aindex = 1;   
            }
            int bindex = 0;
            if(i<b.length() && b.charAt(b.length()-i-1) == '1'){
                bindex = 1;
            }
            out = (aindex+bindex+upindex)%2 + out;
            upindex = (aindex+bindex+upindex)/2;
            i++;
        }
        return out;
    }
}
