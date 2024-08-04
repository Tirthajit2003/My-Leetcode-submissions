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
    public ListNode sortList(ListNode head) {
        ListNode curr=head;
        List<Integer> l=new ArrayList<>();

        while(curr!=null)
        {
            l.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(l);
        ListNode d=new ListNode(-1);
        ListNode c=d;

        for(int i=0;i<l.size();i++)
        {
            c.next=new ListNode(l.get(i));
            c=c.next;
        }
        return d.next;
            

        
    }
}