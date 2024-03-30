class Solution {
    public int find(int[] nums,int k)
    {
        int n=nums.length;
        int s=0,e=0,res=0;
        HashMap<Integer,Integer> h=new HashMap<>();

        for(e=0;e<n;e++)
        {
            h.put(nums[e],h.getOrDefault(nums[e],0)+1);

            while(h.size()>k)
            {
                h.put(nums[s],h.getOrDefault(nums[s],0)-1);
                if (h.get(nums[s])==0) h.remove(nums[s]);
                s++;
            }
            res+=(e-s+1);
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums,k)-find(nums,k-1);
    }
}