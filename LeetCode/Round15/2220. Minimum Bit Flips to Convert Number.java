class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        if((start << 31) != (goal << 31)) cnt++;
        for(int i = 0; i<31;i++){
            int temp1 = 1;
            temp1 = temp1 & (start>>>1);
            start >>>= 1;
            int temp2 = 1;
            temp2 = temp2 & (goal >>>1);
            goal >>>= 1;
            if(temp1 != temp2) cnt++;
        }
        return cnt;
    }
}
