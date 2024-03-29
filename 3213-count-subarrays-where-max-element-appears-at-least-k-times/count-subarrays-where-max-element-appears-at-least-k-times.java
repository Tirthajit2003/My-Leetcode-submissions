class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int maxe=0,maxc=0;
        long total=0;
        for(int i=0;i<n;i++)
        {
            if (nums[i]>maxe) maxe=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            if (nums[i]==maxe) maxc++;
            total+=i+1;
        }
        if (maxc<k) return 0;

        int s=0,c=0,lim=k-1;
        long sub=0;
        for (int e=0;e<n;e++)
        {
            if (nums[e]==maxe) c++;

            while(c>lim)
            {
                if (nums[s]==maxe) c--;
                s++;
            }
            sub+=e-s+1;
        }
        return total-sub;



    }
}