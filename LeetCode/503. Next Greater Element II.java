class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        for(i = 0; i<n;i++){
            if(i == n-1) j = 0;
            else j = i+1;
            while(true){
                if(nums[i] < nums[j]) {
                    ans[i] = nums[j];
                    break;
                }
                if(j == n-1 && i == j){
                    ans[i] = -1;
                    break;
                }
                if(j == n-1){
                    j = 0;
                    continue;
                }
                if(i == j){
                    ans[i] = -1;
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
