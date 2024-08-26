class Solution {

    class Pair implements Comparable<Pair>
    {
        int num,freq;

        Pair(int num,int freq)
        {
            this.num=num;
            this.freq=freq;
        }
        public int compareTo(Pair p)
        {
            return Integer.compare(p.freq,this.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int res[]=new int[k];

        for(int i:nums)
            h.put(i,h.getOrDefault(i,0)+1);

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> e:h.entrySet())
        {
            pq.offer(new Pair(e.getKey(),e.getValue()));
        }
        int c=0;
        while(c<k)
        {
            Pair p=pq.poll();
            res[c]=p.num;
            c++;
        }
        return res;


        
    }
}