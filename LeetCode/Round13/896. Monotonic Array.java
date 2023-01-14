class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return true;
        for(int i = 2; i<n;i++){
            if(nums[i-2] < nums[i-1]){
                if(nums[i-1] > nums[i]) return false;
                if(nums[0] > nums[i-1] || nums[0] > nums[i-2]) return false;
                if(nums[n-1] < nums[i-1] || nums[n-1] < nums[i-2]) return false;
            }
            if(nums[i-2] > nums[i-1]){
                if(nums[i-1] < nums[i]) return false;
                if(nums[0] < nums[i-1] || nums[0] < nums[i-2]) return false;
                if(nums[n-1] > nums[i-1] || nums[n-1] > nums[i-2]) return false;
            }
        }
        return true;
    }
}
