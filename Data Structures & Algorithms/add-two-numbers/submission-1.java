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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        - traverse through list and add the values at l1 and l2
        - if the added value is greater than 9, need to regroup.
        - keep repeating until all values done
        - at the end, add the regrouped value (if any) to the list nodes if there are any left
        */

        ListNode result = new ListNode();
        ListNode dummy = result;
        int regroup = 0;
        while (l1 != null && l2 != null) {
            int res = l1.val + l2.val + regroup;
            regroup = res / 10;
            res = res % 10;

            dummy.next = new ListNode(res);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int res = l1.val + regroup;
            regroup = res / 10;
            res = res % 10;
            dummy.next = new ListNode(res);
            dummy = dummy.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int res = l2.val + regroup;
            regroup = res / 10;
            res = res % 10;
            dummy.next = new ListNode(res);
            dummy = dummy.next;
            l2 = l2.next;
        }

        if (regroup != 0) {
            dummy.next = new ListNode(regroup);
        }

        return result.next;
    }
}
