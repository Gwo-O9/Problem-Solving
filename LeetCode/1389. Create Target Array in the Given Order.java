class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] ans = new int[n];
        int i = 0;
        for(i = 0; i<n;i++){
            temp.add(index[i], nums[i]);
        }
        for(i = 0;i<n;i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
