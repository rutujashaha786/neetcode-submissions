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
        int[] dia = new int[1];
        diameterOfBinaryTreeHelper(root, dia);
        return dia[0];
    }

    public void diameterOfBinaryTreeHelper(TreeNode root, int[] dia){
        if(root == null){
            return;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int diameter = lh + rh;

        dia[0] = Math.max(diameter, dia[0]);

        diameterOfBinaryTreeHelper(root.left, dia);
        diameterOfBinaryTreeHelper(root.right, dia);

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
