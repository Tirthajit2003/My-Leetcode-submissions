class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        int ns=newInterval[0];
        int ne=newInterval[1];
        boolean isdone=false;

        if (n == 0) {
            int ans[][]=new int[1][2];
            ans[0][0]=ns;
            ans[0][1]=ne;
            return ans;
        }
        while(i<n)
        {
            int s=intervals[i][0];
            int e=intervals[i][1];
            if (ns<s && ne<e && !isdone)
            {
                res.add(Arrays.asList(ns,ne));
                isdone=true;
            }
            if (ns<s && !isdone)
            {
                res.add(Arrays.asList(ns,Math.max(ne,e)));
                isdone=true;
            }
            else if(ns>=s && ns<=e && !isdone)
            {
                res.add(Arrays.asList(s,Math.max(e,ne)));
                isdone=true;
            }
            else if (res.size()>0 && res.get(res.size()-1).get(1)>=s)
            {
                res.get(res.size()-1).set(1,Math.max(res.get(res.size()-1).get(1),e));
            }
            else res.add(Arrays.asList(s,e));

            i++;
        }
        if (!isdone)
        {
            res.add(Arrays.asList(ns,ne));
        }
        int l=res.size();
        int ans[][]=new int[l][2];
        for(int j=0;j<l;j++)
        {
            ans[j][0]=res.get(j).get(0);
            ans[j][1]=res.get(j).get(1);
        }
        return ans;
    }
}
