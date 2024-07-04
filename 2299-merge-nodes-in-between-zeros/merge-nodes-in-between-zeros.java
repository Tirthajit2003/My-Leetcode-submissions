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
    public ListNode mergeNodes(ListNode head) {
        ListNode ref=head,s=head,f=head.next;
        int sum=0;
        while(f!=null)
        {
            if (f.val!=0)
            {
                sum+=f.val;
            }
            else
            {
                s.next=new ListNode(sum);
                sum=0;
                s=s.next;
            }
            f=f.next;
        }
        return ref.next;
    }
}