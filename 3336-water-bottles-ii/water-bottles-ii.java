class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res=numBottles,full=0,empty=numBottles;

        while(empty>=numExchange)
        {
            empty-=numExchange;
            full++;
            numExchange++;

            if (empty<numExchange)
            {
                empty+=full;
                res+=full;
                full=0;
            }
        }
        return res;



    }
}