class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i,j;
        for(i = 0 ; i<n;i++){
            int cnt = 0;
            for(j = 0; j<n;j++){
                if(i == j) continue;
                if(nums[i] > nums[j]) cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
