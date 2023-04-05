class Solution {
    public void rotate(int[] nums, int k) {
        int arr[] = new int[nums.length];
        int i;
        for(i = 0; i<nums.length;i++){
            arr[(i+k)%nums.length] = nums[i];
        }
        for(i = 0;i<nums.length;i++){
            nums[i] = arr[i];
        }
    }
}
