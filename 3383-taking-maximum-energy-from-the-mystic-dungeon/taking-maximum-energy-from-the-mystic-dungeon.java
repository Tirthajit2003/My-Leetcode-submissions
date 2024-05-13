class Solution {
    public int start(int[] energy,int i,int k,int[] dp)
    {
        if (i>=energy.length) return 0;
        if (dp[i]!=-1) return dp[i];

        return dp[i]=energy[i]+start(energy,i+k,k,dp);
    
    }
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int res=Integer.MIN_VALUE;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);

        for(int i=0;i<n;i++)
            res=Math.max(res,start(energy,i,k,dp));

        return res;
        
    }
}