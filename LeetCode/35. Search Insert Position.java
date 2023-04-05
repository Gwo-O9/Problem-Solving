class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        while(left <= right){
            
            if(target<nums[left]){
                return left;
            }
            if(target>nums[right]){
                return right+1;
            }
            
            mid = (right+left)/2;
            
            if(target < nums[mid]){
                right = mid-1;
            }
            else if(target > nums[mid]){
                left = mid+1;
            }
            else if(target == nums[mid]){
                return mid;
            }
        }
        return -1;
    }
}
