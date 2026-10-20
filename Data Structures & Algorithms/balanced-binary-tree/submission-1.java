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
    public boolean isBalanced(TreeNode root){
        Boolean[] ans = new Boolean[1];
        ans[0] = true;
        isBalancedHelper(root, ans);
        return ans[0];
    }
    public void isBalancedHelper(TreeNode root, Boolean[] ans) {
        if(root == null){
            return;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int diff = Math.abs(lh - rh);
        if(diff > 1){
            ans[0] = false;
        }

        isBalancedHelper(root.left, ans);
        isBalancedHelper(root.right, ans);

    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }
}
