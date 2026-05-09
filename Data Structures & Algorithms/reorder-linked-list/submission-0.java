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
        first, last, second, second to last, etc.
        
        basically, you take first, then reverse the rest, repeat until no values left
        */

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (head != null) {
            temp.next = head;
            head = reverse(head.next);
            temp = temp.next;
        }

        head = dummy.next;
        
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; // cuz we want the current node to point to the prev node to reverse it
            prev = curr;
            curr = temp;
        }

        return prev;

    }
}
