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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root != null) dfshelper(ans, new String(""), root);
        return ans;
    }

    public void dfshelper(List<String> ans, String s, TreeNode root){
    s += root.val;
    if(root.left == null && root.right == null){
        ans.add(s);
        return;
    }
    if(root.right != null){
        dfshelper(ans, s+"->",root.right);
    }
    if(root.left != null){
        dfshelper(ans,s+"->",root.left);
    }
}
}

