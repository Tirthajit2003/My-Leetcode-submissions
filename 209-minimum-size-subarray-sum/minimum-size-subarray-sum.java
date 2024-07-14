class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int s=0,res=Integer.MAX_VALUE;
        int psum=0;

        for(int e=0;e<n;e++)
        {
            psum+=nums[e];

            while(psum>=target)
            {
                res=Math.min(res,e-s+1);
                psum-=nums[s];
                s++;
            }
        }
        return (res==Integer.MAX_VALUE)? 0:res;
    }
} 