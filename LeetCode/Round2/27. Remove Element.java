class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int curr = 0;
        for(int i = 0;i<len;i++){
            if(nums[i] == val){ //continue until not val is searched
                continue;
            }
            else{ //if not val element is searched, merge it into current index
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
}
