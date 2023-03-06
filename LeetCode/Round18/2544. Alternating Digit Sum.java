class Solution {
    public int alternateDigitSum(int n) {
        String temp = Integer.toString(n);
        int len = temp.length();
        int sum = 0;
        for(int i = 0; i<len;i++){
            int a = (int) temp.charAt(i) - 48;
            sum += i%2 == 0 ? a : -1*a;
        }
        return sum;
    }
}
