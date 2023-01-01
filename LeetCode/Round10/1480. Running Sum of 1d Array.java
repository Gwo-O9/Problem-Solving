class Solution {
    public int[] runningSum(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            count += nums[i];
            nums[i] = count;
        }
        return nums;
    }
}
