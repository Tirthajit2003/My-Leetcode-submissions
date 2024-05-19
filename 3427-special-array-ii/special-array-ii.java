class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length,q=queries.length;
        boolean res[]=new boolean[q];
        int prev[]=new int[n];
        prev[0]=1;
        for(int i=1;i<n;i++)
        {
            if ((nums[i]%2==0 && nums[i-1]%2!=0) || (nums[i]%2!=0 && nums[i-1]%2==0))
                prev[i]=1+prev[i-1];
            else prev[i]=prev[i-1];
        }

        for(int i=0;i<q;i++)
        {
            if (queries[i][1]-queries[i][0]==(prev[queries[i][1]]-prev[queries[i][0]]))
                res[i]=true;
            else res[i]=false;
        }

        return res;
    }
}