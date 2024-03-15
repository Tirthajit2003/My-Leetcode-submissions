class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int psum=0,res=0;

        for(int i=0;i<n;i++)
        {
            psum+=nums[i];
            if (h.containsKey(psum-goal)) res+=h.get(psum-goal);
            if (psum==goal)
            {
                res++;
                h.put(psum,h.getOrDefault(psum,0)+1);
            }
            else h.put(psum,h.getOrDefault(psum,0)+1);
        }
        return res;

    }
}