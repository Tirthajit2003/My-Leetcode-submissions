class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int xor=0;

        if (m%2==0 && n%2==0) return 0;
        else if (m%2!=0 && n%2==0)
        {
            for(int i=0;i<n;i++)
                xor=xor^nums2[i];
            
            
        }
        else if (m%2==0 && n%2!=0)
        {
            for(int i=0;i<m;i++)
                xor=xor^nums1[i];

            
        }
        else
        {
            for(int i=0;i<m;i++)
                xor=xor^nums1[i];
            for(int i=0;i<n;i++)
                xor=xor^nums2[i];
        }
        return xor;
    }
}