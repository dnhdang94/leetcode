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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t1 = head;
        int c = 1;
        while (c < n) {
            t1 = t1.next;
            c++;
        }
        ListNode t2 = new ListNode(0, head);
        while (t1 != null && t1.next != null) {
            t1 = t1.next;
            t2 = t2.next;
        }
        ListNode tt = t2.next;
        if (tt == head) {
            head = head.next;
        } else {
            t2.next = tt.next;
        }
        tt = null;
        return head;
    }
}
