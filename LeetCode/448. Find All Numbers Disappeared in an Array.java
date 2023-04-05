class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int max = nums.length;
        HashSet<Integer> temp = new HashSet<Integer>();
        int i = 0;
        for(i = 0; i<nums.length;i++){
            temp.add(nums[i]);
        }
        i = 1;
        while(i <= max){
            if(!temp.contains(i)) ans.add(i);
            i++;
        }
        return ans;
    }
}
