class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        int a[]={0,0};
        for(int i=0;i<n;i++)
            a[students[i]]++;
        int k=0;

        while(k<n)
        {
            if (a[sandwiches[k]]>0) a[sandwiches[k]]--;
            else break;

            k++;
        }
        return n-k;
    }
}