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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //HashMap for searching root in inorder
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, map, 0, n - 1, 0, n - 1);


    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int inStart, int inEnd, int preStart, int preEnd){

        if(inStart > inEnd){
            return null;
        }

        TreeNode newNode = new TreeNode(preorder[preStart]);

        //get index of root in inorder --- 1 2 3 4 5 6
        int midIndex = map.get(preorder[preStart]);
        int leftSubtreeSize = midIndex - inStart;

        newNode.left = buildTreeHelper(preorder, inorder, map, inStart, midIndex - 1, preStart + 1, preStart + leftSubtreeSize);
        newNode.right = buildTreeHelper(preorder, inorder, map, midIndex + 1, inEnd, preStart + leftSubtreeSize + 1, preEnd);

        return newNode;

    }
}
