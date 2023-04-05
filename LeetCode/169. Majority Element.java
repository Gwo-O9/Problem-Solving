class Solution {
    public int majorityElement(int[] nums) {
        /*sort -> max count == nlogn + n */
        if(nums.length <= 1) return nums[0];
        
        Arrays.sort(nums);
        
        int max = 0;
        int temp = 1;
        int maxidx = 0;
        int i = 0;
        
        while(i<nums.length-1){
            if(nums[i] == nums[i+1]) temp++;
            if((nums[i] != nums[i+1] && max <= temp) || (nums[i] == nums[i+1] && i == nums.length-2 && max <= temp)){
                max = temp;
                maxidx = nums[i] ;
                temp = 1;
            }
            i++;
        }
        return maxidx;
    }
}
