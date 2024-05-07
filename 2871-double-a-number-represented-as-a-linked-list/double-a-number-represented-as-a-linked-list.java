class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        ListNode tail = prev;

        curr = prev;
        int carry = 0;
        while (curr != null) {
            int doubledValue = curr.val * 2 + carry;
            curr.val = doubledValue % 10;
            carry = doubledValue / 10;
            prev = curr;
            curr = curr.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        prev = null;
        curr = tail;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}