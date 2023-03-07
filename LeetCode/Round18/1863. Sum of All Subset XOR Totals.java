class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums,0,0);
        return ans;
    }

    public void helper(int[] nums, int i, int sum){
        if(i == nums.length) {
            ans += sum;
            return;
        }
        helper(nums, i+1, sum ^ nums[i]);
        helper(nums, i+1, sum);
    }
}
