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
        ListNode dummy = new ListNode(0, head); //dummy.next = head
        ListNode slow = dummy;
        ListNode fast = dummy;
        int index = 0;
        // n gap between slow and fast
        while (fast != null && index <= n) {
            fast = fast.next;
            index++;
        }

        // go until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow will be at nth from end

        slow.next = slow.next.next;
        return dummy.next;
    }
}
