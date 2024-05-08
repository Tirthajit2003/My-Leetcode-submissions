class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String res[]=new String[n];
        int sd[]=Arrays.copyOf(score,n);
        HashMap<Integer,String> h=new HashMap<>();
        Arrays.sort(sd);
        for(int i=n-1;i>=0;i--)
        {
            if (i==n-1) h.put(sd[i],"Gold Medal");
            else if (i==n-2) h.put(sd[i],"Silver Medal");
            else if (i==n-3) h.put(sd[i],"Bronze Medal");
            else h.put(sd[i],Integer.toString(n-i));
        }
        for(int i=0;i<n;i++)
        {
            res[i]=h.get(score[i]);
        }
        return res;
    }
}