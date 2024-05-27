class Solution {
    public int specialArray(int[] nums) {
        int n=nums.length;
        int res=-1,maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
            maxi=Math.max(maxi,nums[i]);

        for(int i=1;i<=maxi;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if (nums[j]>=i) c++;
            }
            if (c==i) return i;
        }
        return res;
    }
}