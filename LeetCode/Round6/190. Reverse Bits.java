public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int sum = 0;
        for(int i = 0;i<=31;i++){
            int temp = n & 1;
            int add = temp << (31-i);
            sum |= add;
            n >>= 1;
        }
        return sum;
    }
}
