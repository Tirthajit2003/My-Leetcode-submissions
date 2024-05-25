class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int num:nums)
            h.put(num,h.getOrDefault(num,0)+1);

        int res=0;
        for(Map.Entry<Integer,Integer> e:h.entrySet())
        {
            if (e.getValue()==2) res^=e.getKey();
        }
        return res;

    }
}