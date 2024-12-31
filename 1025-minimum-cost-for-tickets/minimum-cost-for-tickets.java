class Solution {
    public int find(int idx,int next_iss,int[] days,int[] costs,int[][] dp)
    {
        if (next_iss>days[days.length-1]) return 0;

        if (idx>days.length) return 0;
        if (dp[idx][next_iss]!=-1) return dp[idx][next_iss];

        if (next_iss==0 || days[idx]>=next_iss)
        {
            int od=costs[0]+find(idx+1,days[idx]+1,days,costs,dp);
            int sd=costs[1]+find(idx+1,days[idx]+7,days,costs,dp);
            int td=costs[2]+find(idx+1,days[idx]+30,days,costs,dp);

            return dp[idx][next_iss]=Math.min(od,Math.min(sd,td));
        }
        return dp[idx][next_iss]=find(idx+1,next_iss,days,costs,dp);
    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][]=new int[days.length][366];
        for(int[] r:dp)
            Arrays.fill(r,-1);

        return find(0,0,days,costs,dp);
    }
}