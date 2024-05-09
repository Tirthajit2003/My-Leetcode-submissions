class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(long num:happiness)
            pq.add(num);
        
        int d=0;
        long sum=0;
        while(!pq.isEmpty() && k-->0)
        {
           long t=pq.poll(); 
           if (t-d>=0) sum+=t-d;
            
            d++;  
        }
        return sum;
    }
}