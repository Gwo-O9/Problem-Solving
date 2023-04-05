class Solution {
    public boolean hasAlternatingBits(int n) {
        int temp2 = n&1;
        while(n>0){
            int temp = temp2;
            n >>>=1;
            temp2 = n & 1;
            if(temp2 == temp) return false;
        }
        return true;
    }
}
