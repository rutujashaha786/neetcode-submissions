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
    public class Pair{
        long max;
        long min;
    }
    public boolean isValidBST(TreeNode root) {
        if(isValidBSTHelper(root) == null){
            return false;
        }
        return true;
    }

    public Pair isValidBSTHelper(TreeNode root){
        if(root == null){
            Pair bp = new Pair();
            bp.min = Long.MAX_VALUE;  //to handle edge case where Simgle Node is +Infinity/-Infinity in Integer terms, BST condition check fails - (lp.max < root.val && root.val < rp.min)
            bp.max = Long.MIN_VALUE;
            return bp;
        }

        Pair lp = isValidBSTHelper(root.left);
        if(lp == null){
            return null;
        }
        Pair rp = isValidBSTHelper(root.right);
        if(rp == null){
            return null;
        }

        if(!(lp.max < root.val && root.val < rp.min)){
            return null;
        }

        Pair p = new Pair();
        p.max = Math.max(root.val, Math.max(lp.max, rp.max));
        p.min = Math.min(root.val, Math.min(lp.min, rp.min));

        return p;
    }


}
