class Solution {
    int dr[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] grid,boolean[][] vis,int r,int c)
    {
        vis[r][c]=true;
        
        for(int[] d:dr)
        {
            if (r+d[0]>=0 && r+d[0]<grid.length && c+d[1]>=0 && c+d[1]<grid[0].length &&
             vis[r+d[0]][c+d[1]]==false && grid[r+d[0]][c+d[1]]=='1')
            {
                dfs(grid,vis,r+d[0],c+d[1]);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int res=0;
        boolean vis[][]=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (grid[i][j]=='1' && vis[i][j]==false)
                {
                    dfs(grid,vis,i,j);
                    res++;
                }
            }
        }
        return res;

    }
}