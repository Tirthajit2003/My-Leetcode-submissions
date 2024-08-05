class Solution {
    public int find(int i,int j,String text1,String text2,int[][] dp)
    {
        if (i==text1.length() || j==text2.length()) return 0;
        if (dp[i][j]!=-1) return dp[i][j];

        if (text1.charAt(i)==text2.charAt(j))
            return 1+find(i+1,j+1,text1,text2,dp);

        return dp[i][j]=Math.max(find(i+1,j,text1,text2,dp),find(i,j+1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int dp[][]=new int[n][m];

        for(int[] r:dp)
            Arrays.fill(r,-1);
        
        int res=find(0,0,text1,text2,dp);
        return res;
    }
}