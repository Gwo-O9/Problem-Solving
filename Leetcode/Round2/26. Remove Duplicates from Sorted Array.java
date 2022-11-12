class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int curr = 1; // arr's first elemenet is always first element
        for(int i = 0;i<len-1;i++){
            if(nums[i] == nums[i+1]){ //continue until different element is searched
                continue;
            }
            else{ //if different element is searched, merge it into current index
                nums[curr] = nums[i+1];
                curr++;
            }
        }
        return curr;
    }
}
