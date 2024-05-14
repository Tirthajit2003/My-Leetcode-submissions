class Solution {
    public int find(int i,int j,int[][] grid)
    {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) 
            return 0;
        
        int curr=grid[i][j];
        grid[i][j]=0;
        int res=0;

        int left=find(i,j-1,grid);
        int right=find(i,j+1,grid);
        int up=find(i-1,j,grid);
        int down=find(i+1,j,grid);

        res=curr+Math.max(left,Math.max(right,Math.max(up,down)));

        grid[i][j]=curr;

        return res;

    }
    public int getMaximumGold(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int res=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (grid[i][j]!=0)
                    res=Math.max(res,find(i,j,grid));
            }  
        }
        return res;
        
    }
}