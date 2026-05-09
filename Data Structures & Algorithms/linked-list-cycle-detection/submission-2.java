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
    public boolean hasCycle(ListNode head) {
        /*
        2 pointers slow pointer + fast pointer
        - p1 starts at 0 and increases by 1
        - p2 starts at 1 and increases by 2
        */
        if (head == null || head.next == null) {
            return false;
        } 

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            } else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        return false;
        
    }
}
