class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < 0) index++;
        }
        int left = index-1; int right = index; int j = 0;
        while(left >= 0 || right < nums.length){
            if(left < 0){
                arr[j] = (int) Math.pow(nums[right],2);
                right++;
            }
            else if(right >= nums.length){
                arr[j] = (int) Math.pow(nums[left],2);
                left--;
            }
            else if(Math.abs(nums[left]) >= Math.abs(nums[right])) {
                arr[j] = (int) Math.pow(nums[right],2);
                right++;
            }
            else {
                arr[j] = (int) Math.pow(nums[left],2);
                left--;
            }
            j++;
        }
        return arr;
    }
}
