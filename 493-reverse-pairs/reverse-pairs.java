class Solution {
    public void merge(int[] nums,int l,int m,int h)
    {
        int n1=m-l+1,n2=h-m;
        int left[]=new int[n1];
        int right[]=new int[n2];

        for(int i=0;i<n1;i++)
            left[i]=nums[l+i];
        
        for(int j=0;j<n2;j++)
            right[j]=nums[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2)
        {
            if (left[i]<=right[j])
            {
                nums[k++]=left[i++];
            }
            else nums[k++]=right[j++];
        }
        while(i<n1) nums[k++]=left[i++];
        while(j<n2) nums[k++]=right[j++];
    }
    public int count(int[] nums,int l,int m,int h)
    {
        int res=0,c=0;
        int j=m+1;

        for(int i=l;i<=m;i++)
        {
            while(j<=h && nums[i]>2*(long)nums[j])
            {
                j++;
            }
            res+=(j-(m+1));
        }
        return res;
    }
    public int mergesort(int[] nums,int l,int h)
    {
        int res=0;
        if (l<h)
        {
            int m=l+(h-l)/2;
            res+=mergesort(nums,l,m);
            res+=mergesort(nums,m+1,h);
            res+=count(nums,l,m,h);
            merge(nums,l,m,h);
        }
        return res;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int res=mergesort(nums,0,n-1);
        return res;
    }
}