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
    List<Integer> out;
    public List<Integer> preorderTraversal(TreeNode root) {
        out = new ArrayList<Integer>();
        preorder(root);
        return out;
    }
    
    public void preorder(TreeNode root){
        if(root!= null){
            out.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
