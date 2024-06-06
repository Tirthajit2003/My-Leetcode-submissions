class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if (n%k!=0) return false;

        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i:nums)
            h.put(i,h.getOrDefault(i,0)+1);

        Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            int t=nums[i];
            if (h.containsKey(t))
            {
                int gs=1;
                h.put(t,h.getOrDefault(t,0)-1);
                if(h.get(t)==0) h.remove(t);
                int curr=1;
                while(gs!=k && h.containsKey(t+curr))
                {
                    gs++;
                    h.put(t+curr,h.getOrDefault(t+curr,0)-1);
                    if(h.get(t+curr)==0) h.remove(t+curr);
                    curr++;
                }
                if (gs!=k) return false;
            }
        }
        return true;
    }
}