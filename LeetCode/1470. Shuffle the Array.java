class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];
        for(int i = 0; i<nums.length/2;i++){
            ans[i*2] = nums[i];
            ans[i*2+1] = nums[n+i];
        }
        return ans;
    }
}
