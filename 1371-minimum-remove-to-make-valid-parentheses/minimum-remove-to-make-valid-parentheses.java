class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int c=0;
        for(int i=0;i<n;i++)
        {
            if (ch[i]=='(') c++;
            else if(ch[i]==')')
            {
                if (c>0) c--;
                else ch[i]='#';
            }
        }
        c=0;
        for(int i=n-1;i>=0;i--)
        {
            if (ch[i]==')') c++;
            else if(ch[i]=='(')
            {
                if (c>0) c--;
                else ch[i]='#';
            }
        }
        for(int i=0;i<n;i++)
        {
            if (ch[i]!='#') sb.append(ch[i]);
        }
        return sb.toString();
    }
}