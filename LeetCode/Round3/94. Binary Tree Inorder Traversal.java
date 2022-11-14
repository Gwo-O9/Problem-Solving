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
    
    public List<Integer> inorderTraversal(TreeNode root) {
    
        out = new ArrayList<Integer>();
        Inorder(root);
        return out;
    }
    
    public void Inorder(TreeNode root){
        if (root != null){
        Inorder(root.left);
        out.add(root.val);
        Inorder(root.right);
        }
    }
}
