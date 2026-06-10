
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
/*
SOLUTION 1:
        ListNode res = new ListNode();
        ListNode dummy = res;

        while (head != null) {
            dummy.next = head;
            head = reverse(head.next);
            dummy = dummy.next;
        }
        head = res.next;
        */

        // SOLUTION 2
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at middle (4 5 6)
        // head is 0 1 2 3 4 5 6

        // reverse slow
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        // merge
        ListNode temp = head;
        while (second != null) {
                ListNode t1 = temp.next;
                ListNode t2 = second.next;
                temp.next = second;
                second.next = t1;
                temp = t1;
                second = t2;
        }



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
