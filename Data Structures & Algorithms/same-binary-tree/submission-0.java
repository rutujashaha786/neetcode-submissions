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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        //preorder - short circuit
        if(p.val != q.val){
            return false;
        }

        boolean lres = isSameTree(p.left, q.left);
        if(!lres){
            return false;
        }
        boolean rres = isSameTree(p.right, q.right);
         if(!rres){
            return false;
        }

        return true;

    }
}
