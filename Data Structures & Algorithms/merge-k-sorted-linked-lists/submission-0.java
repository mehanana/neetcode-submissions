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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
            return mergeLists(lists[0], lists[1]);
        } else {
            int mid = lists.length / 2;
            return mergeLists(mergeKLists(Arrays.copyOfRange(lists, 0, mid)),
                            mergeKLists(Arrays.copyOfRange(lists, mid, lists.length)));
        }

    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummy = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        } else if (l2 != null) {
            dummy.next = l2;
        }

        return result.next;
    }
}
