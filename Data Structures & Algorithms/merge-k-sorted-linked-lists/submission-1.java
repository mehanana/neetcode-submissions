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
        /*
        - merge first 2, then next 2, etc. and repeat until all lists are merged
        */
        if (lists.length == 0) {
            return null;
        }
        List<ListNode> merged = new ArrayList<>(Arrays.asList(lists));
        while (merged.size() != 1) {
            merged.add(mergeTwoLists(merged.get(0), merged.get(1)));
            merged.remove(0);
            merged.remove(0);
        }
        return merged.get(0);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode dummy = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // add l1
                dummy.next = l1;
                l1 = l1.next;
            } else {
                // add l1
                dummy.next = l2;
                l2 = l2.next;
            }
            
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        }
        if (l2 == null) {
            dummy.next = l1;

        }
        return res.next;
    }
}
