class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i<nums.length;i+=2){
            for(int j = 0;j<nums[i];j++){
                temp.add(nums[i+1]);
            }
        }
        int[] ans = new int[temp.size()];
        for (int k = 0; k < temp.size(); k++){
            ans[k] = temp.get(k);
        }   
        return ans;
    }
}
