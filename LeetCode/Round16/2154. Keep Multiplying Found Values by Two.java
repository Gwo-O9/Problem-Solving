class Solution {
    public int findFinalValue(int[] nums, int original) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] == original){
                original *= 2;
                i = 0;
                continue;
            }
            i++;
        }
        return original;
    }
}
