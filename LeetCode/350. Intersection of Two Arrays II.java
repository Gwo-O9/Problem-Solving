class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int[] arr = new int[nums1.length];
        int index = 0;
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] != nums2[j]){
                if(nums1[i] < nums2[j]) i++;
                else j++;
                continue;
            }
            else{
                arr[index++] = nums2[j];
                i++;
                j++;
            }
        }
        int[] ans = new int[index];
        for(int k =0; k<index;k++){
            ans[k] = arr[k];
        }
        return ans;
    }
}
