
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.next != null) {
            prev = cur;
            cur = cur.next;
            if (prev.val == cur.val) {
                ListNode next = cur.next;
                cur = prev;
                prev.next = next;
            }

        }
        return head;
    }
}