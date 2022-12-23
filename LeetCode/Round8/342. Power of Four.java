class Solution {
    public boolean isPowerOfFour(int n) {
        int count = 0;
        int num = n;
        for(int i = (int) Math.sqrt(n)+1; i>=0;i--){
                if(Math.pow(2,i) <= num){
                    count++;
                    num -= Math.pow(2,i);
                }
            }
        n &= 715827882; // 715827882 is 101010101010101010101010101010 in bit
        if(count == 1 && n == 0) return true;
        else return false;
    }
}
