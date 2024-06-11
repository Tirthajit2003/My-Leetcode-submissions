class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n=arr2.length,m=arr1.length;
        int freq[]=new int[1001];

        for(int i=0;i<m;i++)
            freq[arr1[i]]++;

        int res[]=new int[m];
        int j=0;

        for(int i=0;i<n;i++)
        {
            int curr=arr2[i];
            while(freq[curr]>0)
            {
                res[j++]=curr;;
                freq[curr]--;
            }
        }
        for(int i=0;i<=1000;i++)
        {
            while(freq[i]>0)
            {
                res[j++]=i;
                freq[i]--;
            }
        }

        return res;
    }
}