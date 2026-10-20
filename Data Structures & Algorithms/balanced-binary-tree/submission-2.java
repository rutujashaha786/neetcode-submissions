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

//PostOrder : Not much intutive (like its preorder)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean lans = isBalanced(root.left);
        boolean rans = isBalanced(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int diff = Math.abs(lh - rh);
        if(diff > 1){
            return false;
        }

        return lans && rans;

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
