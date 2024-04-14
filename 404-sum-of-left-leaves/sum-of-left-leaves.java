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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int res=0;

        while(!q.isEmpty())
        {
            TreeNode t=q.poll();
            if (t.left!=null)
            {
                q.offer(t.left);
                if (t.left.left==null && t.left.right==null)
                    res+=t.left.val;
            };
            if (t.right!=null) q.offer(t.right);
        }
        return res;

    }
}