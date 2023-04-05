class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<String>();
        int low = 0; int high = 1;
        while(low < nums.length){
            while(high < nums.length && nums[high] == nums[high-1]+1) high++;
            if(low == high-1) ans.add(Integer.toString(nums[low]));
            else{
                String anshelp = new String("");
                anshelp = anshelp + Integer.toString(nums[low]) + "->" + Integer.toString(nums[high-1]);
                ans.add(anshelp);
            }
            low = high;
            high++;
        }
        return ans;
    }
}
