class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        int[] arr = new int[digits.length+1];
        
        for(int i = digits.length-1;i>0;i--){
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        if(digits[0] == 10){
            arr[0] = 1;
            arr[1] = 0;
            for(int j = 2; j<digits.length;j++){
                arr[j] = digits[j-1];
                }
            return arr;
            }
        else{
            return digits;
        }
    }
}
