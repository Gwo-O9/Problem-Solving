class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        if(root.left != null && root.left.right == null && root.left.left == null) sum += root.left.val;
        sum = sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }
}
