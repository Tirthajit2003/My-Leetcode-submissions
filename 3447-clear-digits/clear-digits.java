class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if (Character.isDigit(c))
            {
                if (!st.isEmpty()) st.pop();
            }
            else st.push(c);
        }
        StringBuilder sb=new StringBuilder();

        while(!st.isEmpty())
            sb.insert(0,st.pop());
        
        return sb.toString();
    }
}