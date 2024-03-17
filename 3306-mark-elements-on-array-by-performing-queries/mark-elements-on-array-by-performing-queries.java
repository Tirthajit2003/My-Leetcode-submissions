class Pair implements Comparable<Pair> {
    int val, idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    public int compareTo(Pair p) {
        if (this.val == p.val)
            return Integer.compare(this.idx, p.idx);

        return Integer.compare(this.val, p.val);
    }
}
class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean vis[]=new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        long[] res = new long[m];
        long sum=0;

        for (int i = 0; i < n; i++)
        {
            pq.add(new Pair(nums[i], i));
            sum+=nums[i];
        }
            

        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (!vis[index])
            {
                vis[index]=true;
                sum-=nums[index];
            }
            
            pq = pq.stream()
    .filter(p -> p.idx != index)
    .collect(Collectors.toCollection(PriorityQueue::new));


            while (!pq.isEmpty() && k-- > 0) {
                Pair p = pq.poll();
                if (!vis[p.idx])
                {
                    vis[p.idx]=true;
                    sum-=nums[p.idx];
                }
                    
            }
            res[i] = sum;
        }
        return res;
    }
}
