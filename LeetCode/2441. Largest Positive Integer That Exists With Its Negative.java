class Solution {
    public int findMaxK(int[] nums) {
        int MAX = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= 0 || MAX > nums[i]) continue;
            for(int j = 0;j<nums.length;j++){
                if(nums[i] == -nums[j]){
                    MAX = nums[i];
                } 
            }
        }
        return MAX;
    }
}
