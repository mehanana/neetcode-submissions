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
    public ListNode reverseList(ListNode head) {
        ListNode copy = head;
        ListNode res = null;
        while (copy != null) {
            ListNode temp = new ListNode(copy.val);
            temp.next = res;
            res = temp;
            copy = copy.next;
        }
        return res;
        
    }
}
