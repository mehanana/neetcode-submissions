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
        goes from least sig to most sig digit
        */
        ListNode res = new ListNode();
        ListNode dummy = res;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;

            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;

            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            int digit = sum % 10;
            dummy.next = new ListNode(digit);
            carry = sum / 10;
            dummy = dummy.next;
        }

        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }
        return res.next;
    }
}
