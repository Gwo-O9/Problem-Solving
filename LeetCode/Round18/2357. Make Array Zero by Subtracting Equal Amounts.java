class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for(int i = 0; i<n;i++){
            set.add(nums[i]);
        }
        set.remove(0);
        return set.size();
    }
}
