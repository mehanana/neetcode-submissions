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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        not recommended space complexity:
        assuming i can modify the current lists, i will make a new result listnode and add to that
        */

        /*
        1 -> 4 -> null
        2 -> 3 -> null

        result:
        1 -> null; compare 4 -> null and 2 -> 3 -> null
        1 -> 2 -> null; compare 4 -> null and 3 -> null
        1 -> 2 -> 3

        */

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
        
    }
}