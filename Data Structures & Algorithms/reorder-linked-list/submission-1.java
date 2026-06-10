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
    public void reorderList(ListNode head) {
        /*
        0 -> reverse list -> 6 -> reverse list
        OR
        - split head into 2 lists (0, 1, 2, 3) & (4, 5, 6)
        - reverse 2nd list (456 -> 6 5 4)
        - then merge
        */

        ListNode res = new ListNode();
        ListNode dummy = res;

        while (head != null) {
            dummy.next = head;
            head = reverse(head.next);
            dummy = dummy.next;
        }
        head = res.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }
}
