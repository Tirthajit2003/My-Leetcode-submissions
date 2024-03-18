class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int end=points[0][1],arrow=1;
        int n=points.length;
        for(int i=1;i<n;i++)
        {
            if (points[i][0]<=end) continue;
            else 
            {
                
                arrow++;
                end=points[i][1];
            }
        }
        return arrow;
    }
}