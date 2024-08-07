class neighborSum {
    int[][] grid;
    public neighborSum(int[][] grid) {
       this.grid=grid; 
    }
    
    public int adjacentSum(int value) {
        int n=grid.length;
        int res=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (grid[i][j]==value)
                {
                    if (i+1<n) res+=grid[i+1][j];
                    if (i-1>=0)  res+=grid[i-1][j];
                    if (j-1>=0) res+=grid[i][j-1];
                    if (j+1<n) res+=grid[i][j+1];

                    return res;
                }
            }
        }
        return res;
    }
    
    public int diagonalSum(int value) {
        int n=grid.length;
        int res=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (grid[i][j]==value)
                {
                    if (i-1>=0 && j-1>=0) res+=grid[i-1][j-1];
                    if (i-1>=0 && j+1<n) res+=grid[i-1][j+1];
                    if (i+1<n && j-1>=0) res+=grid[i+1][j-1];
                    if (i+1<n && j+1<n) res+=grid[i+1][j+1];
                    return res;
                }
            }
        }
        return res;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */