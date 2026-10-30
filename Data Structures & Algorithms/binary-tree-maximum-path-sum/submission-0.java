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

    public int maxPathSum(TreeNode root){
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max[0];
    }

    public int maxPathSumHelper(TreeNode root, int[] max) {
        if(root == null){
            return 0;
        }
        int lpathSum = Math.max(0, maxPathSumHelper(root.left, max));
        int rpathSum = Math.max(0,maxPathSumHelper(root.right, max));

        int pathWithLeft = root.val + lpathSum;
        int pathWithRight = root.val + rpathSum;
        int pathWithBoth = root.val + lpathSum + rpathSum;

        int globalAns = Math.max(pathWithBoth, Math.max(pathWithLeft, pathWithRight));

        max[0] = Math.max(globalAns, max[0]);

        int returnAns = Math.max(pathWithLeft, pathWithRight);

        return returnAns;
    }
}
