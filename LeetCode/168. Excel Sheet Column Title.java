class Solution {
    public String convertToTitle(int columnNumber) {
        String output = new String("");
        
        while(columnNumber > 0){
            if(columnNumber%26 == 0){
                output = String.valueOf((char)(64+26)) + output;
                columnNumber = columnNumber/26 -1;
            }
            else{
            output = String.valueOf((char)(64+columnNumber%26)) + output;
            columnNumber /= 26;
            }
        }
        return output;
    }
}
