class Solution {
    public int countOdds(int low, int high) {
        int num = high - low;
        if(low%2 == 0 && high%2 == 0) return num/2;
        else return num/2+1;
    }
}
