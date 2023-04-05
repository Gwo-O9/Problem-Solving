class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length;i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                arr[i] = (char)(arr[i-1] + (arr[i] - 48));
            }
        }
        return new String(arr);
    }
}
