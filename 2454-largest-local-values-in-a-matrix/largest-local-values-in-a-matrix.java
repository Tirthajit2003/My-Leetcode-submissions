class Solution {
    public int getMax(int i,int j,int[][] grid)
    {
        int max=Integer.MIN_VALUE;
        for(int a=i;a<=i+2;a++)
        {
            for(int b=j;b<=j+2;b++)
            {
                max=Math.max(max,grid[a][b]);
            }
        }
        return max;
    }
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int a[][]=new int[n-2][n-2];
        for(int i=0;i<n-2;i++)
        {
            for(int j=0;j<n-2;j++)
            {
                a[i][j]=getMax(i,j,grid);
            }
        }
        return a;
    }
}