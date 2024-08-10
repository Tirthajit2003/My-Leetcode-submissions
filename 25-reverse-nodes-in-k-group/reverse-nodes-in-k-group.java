/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findK(ListNode curr,int k)
    {
        ListNode temp=curr;
        int c=0;

        while(temp!=null && c<k-1)
        {
            temp=temp.next;
            c++;
        }
            

        return temp;
    }
    public ListNode reverseLL(ListNode head)
    {
        ListNode prev=null,curr=head;

        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;


    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head,mh=null,nh=null,ns=null,pe=null,st=null,end=null;

        while(curr!=null)
        {
            st=curr;
            end=findK(st,k);
            if (end==null)
            {
                if(pe!=null) pe.next=st;

                break;
            }
            ns=end.next;
            end.next=null;
            nh=reverseLL(st);
            if (mh==null) mh=nh;

            if(pe==null) pe=st;
            else 
            {
                pe.next=nh;
                pe=st;
            }

            

            curr=ns;
        }
        return mh;
    }
}