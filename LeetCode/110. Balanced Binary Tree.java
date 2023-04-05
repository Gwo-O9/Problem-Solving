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
    public boolean isBalanced(TreeNode root) {
         if(root == null) return true;
         int lefth = maxDepth(root.left) +1;
         int righth = maxDepth(root.right) +1;
         if(lefth - righth >= 2 || righth - lefth >= 2) return false;
         return isBalanced(root.right) && isBalanced(root.left);
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }
}
