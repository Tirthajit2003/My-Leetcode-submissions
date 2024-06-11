class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n=arr2.length,m=arr1.length;
        int freq[]=new int[1001];

        for(int i=0;i<m;i++)
            freq[arr1[i]]++;

        List<Integer> l=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            int curr=arr2[i];
            while(freq[curr]>0)
            {
                l.add(curr);
                freq[curr]--;
            }
        }
        for(int i=0;i<=1000;i++)
        {
            while(freq[i]>0)
            {
                l.add(i);
                freq[i]--;
            }
        }
        int len=l.size();
        int res[]=new int[len];

        for(int i=0;i<len;i++)
            res[i]=l.get(i);

        return res;
    }
}