class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int m=logs.length;
        int id=logs[0][0];
        int md=logs[0][1];

        for(int i=1;i<m;i++)
        {
            int time=logs[i][1]-logs[i-1][1];
            if (time>md)
            {
                md=time;
                id=logs[i][0];
            }
            else if (time==md) id=Math.min(id,logs[i][0]);
        }
        return id;
    }
}