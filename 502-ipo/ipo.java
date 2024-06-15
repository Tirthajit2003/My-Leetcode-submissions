class Activity {
    int profit, capital;

    Activity(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class ActivityCmp implements Comparator<Activity>
{
    public int compare(Activity a1,Activity a2)
    {
        if (a1.capital==a2.capital)
            return Integer.compare(a2.profit,a1.profit);
        
        return Integer.compare(a1.capital,a2.capital);
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        Activity act[]=new Activity[n];

        for(int i=0;i<n;i++)
            act[i]=new Activity(profits[i],capital[i]);

        Arrays.sort(act,new ActivityCmp());

        PriorityQueue<Activity> pq=new PriorityQueue<>((a1,a2)->Integer.compare(a2.profit,a1.profit));

        int curr=w,s=0;
        for(int i=0;i<k;i++)
        {
            while(s<n && act[s].capital<=curr)
            {
                pq.offer(act[s]);
                s++;

            }
            if (pq.isEmpty()) break;

            curr+=pq.poll().profit;
        }
        return curr;






    }
}