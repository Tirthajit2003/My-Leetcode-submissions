class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n=points.length;
        ArrayList<Integer> l=new ArrayList<>();

        for (int[] p:points)
            l.add(p[0]);

        Collections.sort(l);

        int len=l.size();
        int s=0,e=0;
        int res=0;

        while(e<len)
        {
            if ((l.get(e)-l.get(s))>w)
            {
                res++;
                s=e;
            }
            e++;
        }
        res++;
        return res;
        

    }
}