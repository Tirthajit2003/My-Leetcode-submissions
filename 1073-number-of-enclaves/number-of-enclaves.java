class Solution {
    int dr[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int i,int j,boolean[][] vis,int[][] grid)
    {
        vis[i][j]=true;

        for(int d[]:dr)
        {
            if (i+d[0]<grid.length && i+d[0]>=0 && j+d[1]<grid[0].length && j+d[1]>=0 && !vis[i+d[0]][j+d[1]] && grid[i+d[0]][j+d[1]]==1)
                dfs(i+d[0],j+d[1],vis,grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int res=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if ((i==0 || j==0 || i==m-1 || j==n-1) && !vis[i][j] && grid[i][j]==1)
                        dfs(i,j,vis,grid);
            }
            
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (!vis[i][j] && grid[i][j]==1) res++;
            }
        }
        return res;
    }
}