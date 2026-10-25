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

    /* ---------with Return type

public int inorder(TreeNode root, int k, int[] count) {
    if (root == null) {
        return -1;
    }

    int left = inorder(root.left, k, count);

    if (left != -1) {
        return left;
    }

    count[0]++;

    if (count[0] == k) {
        return root.val;
    }

    int right = inorder(root.right, k, count);

    if (right != -1) {
        return right;
    }

    return -1;
}



    */

    


}
