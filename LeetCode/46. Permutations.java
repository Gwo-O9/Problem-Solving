class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        helper(0,nums,ans);
        return ans;
    }

    public void helper(int i, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> temp = new LinkedList<Integer>();
            for(int j = 0; j<nums.length;j++){
                temp.add(nums[j]);
            }
            ans.add(temp);
        }
        for(int k = i; k<nums.length;k++){
            swap(nums,i,k);
            helper(i+1,nums,ans);
            swap(nums,i,k);
        }
    }

    public void swap(int nums[],int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
