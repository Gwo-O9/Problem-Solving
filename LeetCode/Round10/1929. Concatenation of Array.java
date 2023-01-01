class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for(int i = 0; i<nums.length;i++){
            ans[i] = nums[i];
        }
        for(int j = 0; j<nums.length;j++){
            ans[j+nums.length] = nums[j];
        }
        return ans;
    }
}
