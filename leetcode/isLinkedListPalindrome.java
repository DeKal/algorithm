
// https://leetcode.com/problems/palindrome-linked-list
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
class isLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        var cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        Stack<ListNode> stack = new Stack();

        int i=0;
        cur = head;
        while (i<size/2) {
            stack.push(cur);
            cur = cur.next;
            ++i;
        }

        if (size%2 == 1) {
            ++i;
            cur = cur.next;
        }

        while (i<size) {
            var topNode = stack.pop();
            if (cur.val != topNode.val) {
                return false;
            }
            cur = cur.next;
            ++i;
        }


        return true;
    }
}
