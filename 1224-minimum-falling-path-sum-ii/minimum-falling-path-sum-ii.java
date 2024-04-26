class Solution {
    public int find(int i,int j,int[][] grid,int[][] dp)
    {
        if (i==grid.length-1) return grid[i][j];
        if (dp[i][j]!=-1) return dp[i][j];

        int res=Integer.MAX_VALUE;

        for(int k=0;k<grid.length;k++)
        {
            if (k!=j) res=Math.min(res,grid[i][j]+find(i+1,k,grid,dp));
        }
        return dp[i][j]=res;
    }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int res=Integer.MAX_VALUE;
        int dp[][]=new int[n][n];
        for(int[] r:dp)
            Arrays.fill(r,-1);

        for(int j=0;j<n;j++)
            res=Math.min(res,find(0,j,grid,dp));

        return res;
    }
}