class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for(int i = 0; i<n;i++){
            if(set.contains(nums[i])) return nums[i];
            else set.add(nums[i]);
        }
        return 0;
    }
}
