class Solution {
    public int rob(int[] nums) {
        int next = 0; //next house's money
        int nextnext = 0; // next->next house's money
        int max = 0; //house that robber is in
        for(int i = 0; i<nums.length;i++){
            max = Math.max(nums[i] + nextnext, next);
            nextnext = next; //next->next house is now next house
            next = max; // next house is now present house
        }
        return max;
    }
}

