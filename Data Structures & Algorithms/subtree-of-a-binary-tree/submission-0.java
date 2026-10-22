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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        
        boolean ans = sameTree(root, subRoot);
        if(ans){
            return true;
        }

        boolean lres = isSubtree(root.left, subRoot);
        if(lres){
            return true;
        }
        boolean rres = isSubtree(root.right, subRoot);
        if(rres){
            return true;
        }

        return false;

    }

    public boolean sameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        boolean lres = sameTree(root.left, subRoot.left);
        if(!lres){
            return false;
        }
        boolean rres = sameTree(root.right, subRoot.right);
        if(!rres){
            return false;
        }

        return true;

    }
}
