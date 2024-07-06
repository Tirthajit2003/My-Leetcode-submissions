class Solution {
    public int passThePillow(int n, int time) {
        int i=1;
        int dir=1;
        while(time>0)
        {
            if (dir==1) i++;
            if (dir==-1) i--;

            if (i==1|| i==n)
            {
                dir*=-1;
            }

            time--;
        }
        return i;
    }
}