class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = nums3.length;
        int i = 0;
        int[] cnt = new int[100];
        HashSet set = new HashSet<Integer>();
        List<Integer> ans = new LinkedList<Integer>();
        for(i = 0; i<n1;i++){
            if(!set.contains(nums1[i])) {
                cnt[nums1[i]-1]++;
                set.add(nums1[i]);
            }
        }
        set.clear();
        for(i = 0; i<n2;i++){
            if(!set.contains(nums2[i])) {
                cnt[nums2[i]-1]++;
                set.add(nums2[i]);
            }
        }
        set.clear();
        for(i = 0; i<n3;i++){
            if(!set.contains(nums3[i])) {
                cnt[nums3[i]-1]++;
                set.add(nums3[i]);
            }
        }
        for(i = 0; i<100;i++){
            if(cnt[i] >=2) ans.add(i+1);
        }
        return ans;
    }
}
