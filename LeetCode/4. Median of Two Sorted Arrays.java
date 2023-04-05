class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int i = 0; int j = 0; int k = 0;
        int[] nums = new int[n];
        double ans = 0.0;
        while(i+j < n){
            if(i+j == n/2+2){
                ans = n%2 == 1 ? (double) nums[n/2] : (double) (nums[n/2] + nums[n/2-1])/2;
                return ans; 
            }
            if(i == nums1.length){
                nums[k++] = nums2[j++];
                continue;
            }
            if(j == nums2.length){
                nums[k++] = nums1[i++];
                continue;
            }
            if(nums1[i] <= nums2[j]) nums[k++] = nums1[i++];
            else nums[k++] = nums2[j++];
        }
        ans = n%2 == 1 ? (double) nums[n/2] : (double) (nums[n/2] + nums[n/2-1])/2;
        return ans;
    }
}
