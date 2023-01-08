class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int i,j,k;
        for(i = 0; i<nums1.length;i++){
            int index = -1;
            for(j = 0; j<nums2.length;j++){
                if(nums1[i] == nums2[j]) break;
            }
            for(k = j+1; k<nums2.length;k++){
                if(nums2[j] < nums2[k]) {
                    index = nums2[k];
                    break;
                }
            }
            ans[i] = index;
        }
        return ans;
    }
}
