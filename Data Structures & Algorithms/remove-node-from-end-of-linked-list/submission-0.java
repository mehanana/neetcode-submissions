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
        /*
        find length of list, go until length - n, skip n, then add rest to the list
        */
        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;
        int removeIndex = length - n;
        if (removeIndex == 0) {
            return head.next;
        }

        for (int i = 1; i <= length; i++) {
            if (i == removeIndex) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
