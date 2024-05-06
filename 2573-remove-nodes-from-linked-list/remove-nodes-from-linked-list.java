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
    public ListNode removeNodes(ListNode head) {
        List<Integer> l=new ArrayList<>();
        while(head!=null)
        {
            l.add(head.val);
            head=head.next;
        }

        int n=l.size();
        int maxi=l.get(n-1);
        for(int i=n-2;i>=0;i--)
        {
            if (l.get(i)<maxi) l.set(i,-1);
            else maxi=l.get(i);
        }
        ListNode d=new ListNode(-1);
        ListNode t=d;

        for(int i=0;i<n;i++)
        {
            if(l.get(i)!=-1)
            {
                t.next=new ListNode(l.get(i));
                t=t.next;
            }
        }
        return d.next;
    }
}