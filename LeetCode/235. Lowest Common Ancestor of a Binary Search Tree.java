/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = root;
        TreeNode ptemp = root;
        TreeNode qtemp = root;
        while(true){
            int i = 0; int j = 0;
            if(ptemp.val > p.val){
                ptemp = ptemp.left;
                i = -1;
            }
            else if(ptemp.val < p.val){
                ptemp = ptemp.right;
                i = 1;
            }

            if(qtemp.val > q.val){
                qtemp = qtemp.left;
                j = -1;
            }
            else if(qtemp.val < q.val){
                qtemp = qtemp.right;
                j = 1;
            }
            if((i == -1 && j == 1) || (i == 1 && j == -1)) return LCA;
            if(i == 1 && j == 1) LCA = LCA.right;
            else if(i == -1 && j == -1) LCA = LCA.left;

            if(qtemp.val == q.val && p.val == ptemp.val) break;
        }
        return LCA;
    }
}
