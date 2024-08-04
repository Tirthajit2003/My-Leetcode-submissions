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
    int maxi=Integer.MIN_VALUE;

    public int find(TreeNode root)
    {
        if (root==null) return 0;

        int lp=Math.max(0,find(root.left));
        int rp=Math.max(0,find(root.right));

        maxi=Math.max(maxi,lp+rp+root.val);

        return Math.max(lp,rp)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        find(root);

        return maxi;
    }
}