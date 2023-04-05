/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return Valid(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean Valid(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.left != null){
            if(root.val <= root.left.val || !(root.left.val > min)) return false;
        }
        if(root.right != null){
            if(root.val >= root.right.val || !(root.right.val < max)) return false;
        }
        return Valid(root.left, min, root.val) && Valid(root.right, root.val, max);
    }
}
