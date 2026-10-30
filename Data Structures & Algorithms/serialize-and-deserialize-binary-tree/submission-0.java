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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        preorder(root, res);
        return String.join(",", res);
    }

    public void preorder(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        int[] count = new int[1];
        return buildTree(vals, count);
    }

    public TreeNode buildTree(String[] arr, int[] count){
        if(arr[count[0]].equals("N")){
            count[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[count[0]]));
        count[0]++;

        node.left = buildTree(arr, count);
        node.right = buildTree(arr, count);

        return node;
        
    }


}
