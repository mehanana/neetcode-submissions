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
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
        - get first k nodes
        - break it from rest of head
        - reverse it
        - connect it back to rest of head
        - repeat
        */
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            } else {
                ListNode groupNext = kth.next;
                ListNode prev = groupNext, cur = groupPrev.next;
                while (cur != groupNext) {
                    ListNode temp = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = temp;
                }
            
            }
            ListNode oldHead = groupPrev.next;  // first node, now tail
            groupPrev.next = kth;               // prev section -> new head
            groupPrev = oldHead;                // advance anchor

        }
        return dummy.next;
        
    }

    private ListNode getKth (ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    private ListNode reverse (ListNode head) {
        // head = 2 -> 3 -> null
        ListNode res = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = res;
            res = head; 
            head = temp;
        }
        return res;

    }
}
