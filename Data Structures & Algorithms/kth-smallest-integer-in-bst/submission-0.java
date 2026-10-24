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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] res = new int[1];
        inorder(root, k, count, res);
        return res[0];
    }

    public void inorder(TreeNode root, int k, int[] count, int[] res){
        if(root == null){
            return;
        }
        inorder(root.left, k, count, res);
        count[0]++;
        if(count[0] == k){
            res[0] = root.val;
            return;
        }
        inorder(root.right, k, count, res);
    }


}
