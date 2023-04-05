class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        int i;
        for(i = 0; i<n;i++){
            set.add(nums[i]);
        }
        for(i = 1;i<n+2;i++){
            if(!set.contains(i)) return i;
        }
        return 0;
    }
}
