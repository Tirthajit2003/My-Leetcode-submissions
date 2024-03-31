class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> h=new HashMap<>();
       int presum=0,c=0;
       for(int i=0;i<nums.length;i++)
       {
           presum+=nums[i];
           if (presum==k) c++;
           if (h.containsKey(presum-k)) c+=h.get(presum-k);
        
           h.put(presum,h.getOrDefault(presum,0)+1);
       } 
       return c;
    }
}