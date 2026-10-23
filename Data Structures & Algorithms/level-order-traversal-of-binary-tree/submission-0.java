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
    public List<List<Integer>> levelOrder(TreeNode root) {   
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode parent = q.remove();
                levelList.add(parent.val);

                if(parent.left != null){
                    q.add(parent.left);
                }
                if(parent.right != null){
                    q.add(parent.right);
                }
            }

            ans.add(levelList);
        }

        return ans;
    }
}
