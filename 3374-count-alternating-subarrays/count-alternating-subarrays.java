class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        long res=0;

        for(int i=1;i<n;i++)
        {
            if (nums[i]!=nums[i-1])
                dp[i]+=dp[i-1];
        }
        for(int i=0;i<n;i++)
            res+=dp[i];

        return res;

    }
}