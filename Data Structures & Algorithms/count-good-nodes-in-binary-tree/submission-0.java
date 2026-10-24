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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        goodNodesHelper(root, Integer.MIN_VALUE, count);
        return count[0];
    }

    public void goodNodesHelper(TreeNode root, int max, int[] count){
        if(root == null){
            return;
        }
        
        if(max <= root.val){
            count[0]++;
        }

        max = Math.max(max, root.val);
        goodNodesHelper(root.left, max, count);
        goodNodesHelper(root.right, max, count);
    }
}
