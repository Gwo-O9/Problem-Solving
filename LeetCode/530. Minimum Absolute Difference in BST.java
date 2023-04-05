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
        int min = Integer.MAX_VALUE;
        int prevnode;
    public int getMinimumDifference(TreeNode root) {
        prevnode = -1;
        Inhelper(root);
        return min;
    }
    public void Inhelper(TreeNode root){
        if(root == null) return;
        Inhelper(root.left);
        if(prevnode != -1) min = Math.min(min, Math.abs(root.val - prevnode));
        prevnode = root.val;
        Inhelper(root.right);
    }
}
