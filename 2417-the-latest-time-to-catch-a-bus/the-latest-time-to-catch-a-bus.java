class Solution {
    public boolean check(int[] buses, int[] passengers, int mid,int cap)
    {
        int b=buses.length;
        int p=passengers.length;

        int j=0;
        for(int i=0;i<b;i++)
        {
            int count=0;
            while(j<p && passengers[j]<=buses[i] && passengers[j]<mid && count<cap)
            {
                j++;
                count++;
            }
            if (count==cap) continue;

            if (mid<=buses[i]) return true;
        }
        return false;
    }
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int l = 1, h = buses[buses.length - 1];
        int res = 0;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (check(buses, passengers, m, capacity)) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        HashSet<Integer> passengerSet = new HashSet<>();
        for (int passenger : passengers) {
            passengerSet.add(passenger);
        }

        while (passengerSet.contains(res)) {
            res--;
        }
        return res;
    
    }
}