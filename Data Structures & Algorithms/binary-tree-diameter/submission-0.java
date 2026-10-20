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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lsubtreeDia = diameterOfBinaryTree(root.left);
        int rsubtreeDia = diameterOfBinaryTree(root.right);

        //calculate own diameter
        int lh = height(root.left);
        int rh = height(root.right);
        int dia = lh + rh;

        return Math.max(dia, Math.max(lsubtreeDia, rsubtreeDia));

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
