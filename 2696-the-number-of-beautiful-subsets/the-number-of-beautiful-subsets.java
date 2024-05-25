class Solution {
    public int count(int i,int[] nums,int k,HashMap<Integer,Integer> h)
    {
        if (i==nums.length) return 0;

        int take=0;
        if (!h.containsKey(nums[i]-k) && !h.containsKey(nums[i]+k))
        {
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
            take=1+count(i+1,nums,k,h);
            h.put(nums[i],h.getOrDefault(nums[i],0)-1);
            if (h.get(nums[i])==0)
                h.remove(nums[i]);
            
        }
            

        int ntake=count(i+1,nums,k,h);

        return take+ntake;
    }
    public int beautifulSubsets(int[] nums, int k) {
        return count(0,nums,k,new HashMap<Integer,Integer>());
    }
}