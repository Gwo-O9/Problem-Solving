import java.util.*;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        Set set2 = new HashSet<Integer>();
        
        for(int i = 0; i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int j = 0; j<nums2.length;j++){
            set2.add(nums2[j]);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int k = 0;
        for(int num : set1){
            ans[k++] = num;
        }
        return ans;
    }
}
