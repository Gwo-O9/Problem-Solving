class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int curr = 1;
        for(int i = 0;i<len-1;i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                nums[curr] = nums[i+1];
                curr++;
            }
        }
        return curr;
    }
}
