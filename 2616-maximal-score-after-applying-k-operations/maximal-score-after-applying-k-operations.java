class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=nums.length;

        for(int i=0;i<n;i++)
            pq.offer(nums[i]);

        long sum=0;

        while(!pq.isEmpty() && k-->0)
        {
            int t=pq.poll();
            sum+=t;
            pq.offer((int)Math.ceil(t/3.0));
        }
        return sum;


    }
}