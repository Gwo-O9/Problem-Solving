public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        for(int i = 0;i<=31;i++){
            int temp = n & 1;
            if(temp != 0) sum++;
            n >>= 1;
        }
        return sum;
    }
}
