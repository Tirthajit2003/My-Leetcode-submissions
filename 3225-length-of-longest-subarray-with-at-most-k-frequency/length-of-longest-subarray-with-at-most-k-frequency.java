class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res=0,l=0,n=nums.length,c=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
            if (h.get(nums[i])>k)
            {
                res=Math.max(res,i-l);
                while(h.get(nums[i])>k)
                {
                    if (h.get(nums[l])>0)
                    {
                        h.put(nums[l],h.get(nums[l])-1);
                    }
                    l++;
                }
            }
            
        }
        res=Math.max(res,n-l);
        return res;
        
    }
}