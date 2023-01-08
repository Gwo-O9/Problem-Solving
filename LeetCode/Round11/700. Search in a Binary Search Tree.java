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
    TreeNode result = null;
    public TreeNode searchBST(TreeNode root, int val) {
        preordersearch(root, val);
        return result;
    }

    public void preordersearch(TreeNode root, int val){
        if(root == null) return;

        if(root.val == val) result = root;

        preordersearch(root.left,val);
        preordersearch(root.right,val);
    }
}
