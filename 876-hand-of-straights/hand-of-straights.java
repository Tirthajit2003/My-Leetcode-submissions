class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i:hand)
            h.put(i,h.getOrDefault(i,0)+1);

        Arrays.sort(hand);

        for(int i=0;i<n;i++)
        {
            int t=hand[i];
            if (h.containsKey(t))
            {
                int gs=1;
                h.put(t,h.getOrDefault(t,0)-1);
                if(h.get(t)==0) h.remove(t);
                int curr=1;
                while(gs!=groupSize && h.containsKey(t+curr))
                {
                    gs++;
                    h.put(t+curr,h.getOrDefault(t+curr,0)-1);
                    if(h.get(t+curr)==0) h.remove(t+curr);
                    curr++;
                }
                if (gs!=groupSize) return false;
            }
        }
        return true;

    }
}