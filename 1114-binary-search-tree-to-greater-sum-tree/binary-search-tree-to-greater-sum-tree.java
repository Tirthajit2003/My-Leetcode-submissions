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
    int c=0;
    public void inorder(TreeNode root)
    {
        if (root==null) return;

        inorder(root.right);

        c+=root.val;
        root.val=c;
        

        inorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
}