/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var increasingBST = function(root) {
    let temp = [];
    function helper(root){
        if(root == null) return;
        helper(root.left)
        temp.push(root.val)
        helper(root.right)
    };
    helper(root);
    let ans = new TreeNode(temp[0])
    let temp2 = ans;
    let i = 1
    while(temp.length > i){
        temp2.right = new TreeNode(temp[i])
        temp2 = temp2.right
        i++
    }
    return ans;
};
