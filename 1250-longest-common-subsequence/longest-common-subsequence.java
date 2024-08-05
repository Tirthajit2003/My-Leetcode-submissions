class Solution {
    // public int find(int i,int j,String text1,String text2,int[][] dp)
    // {
    //     if (i==text1.length() || j==text2.length()) return 0;
    //     if (dp[i][j]!=-1) return dp[i][j];

    //     if (text1.charAt(i)==text2.charAt(j))
    //         return 1+find(i+1,j+1,text1,text2,dp);

    //     return dp[i][j]=Math.max(find(i+1,j,text1,text2,dp),find(i,j+1,text1,text2,dp));
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        // Create a dp array with all elements initialized to 0
        int[][] dp = new int[n + 1][m + 1];
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The result is in dp[n][m]
        return dp[n][m];
    }
}

