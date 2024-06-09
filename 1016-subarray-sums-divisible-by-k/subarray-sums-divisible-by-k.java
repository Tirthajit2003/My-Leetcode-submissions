class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int res=0,psum=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(0,1);

        for(int i=0;i<n;i++)
        {
            psum+=nums[i];
            int rem=psum%k;
            if (rem<0) rem+=k;
            if (h.containsKey(rem)) 
            {
                res+=h.get(rem);
                h.put(rem,h.getOrDefault(rem,0)+1);
            }
           
            else h.put(rem,1);
        }
        return res;
        
    }
}