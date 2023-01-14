class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for(int i = 0; i<n;i++){
            nums[i] = start + 2 * i;
        }
        for(int j = 1; j<n;j++){
            nums[0] ^= nums[j];
        }
        return nums[0];
    }
}
