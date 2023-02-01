class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new LinkedList<Boolean>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(temp);
            int n = temp.length;
            int diff = temp[1] - temp[0];
            boolean isArithmetic = true;
            for (int j = 2; j < n; j++) {
                if (temp[j] - temp[j - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            ans.add(isArithmetic);
        }
        return ans;
    }
}
