/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lResultHead = null;
        ListNode lResultCur = null;
        ListNode curPosL1 = l1;
        ListNode curPosL2 = l2;
        int so_du = 0;
        while (curPosL1 != null || curPosL2 != null) {
            int l1Val = (curPosL1 != null) ? curPosL1.val : 0;
            int l2Val = (curPosL2 != null) ? curPosL2.val : 0;
            int sum = l1Val + l2Val + so_du;
            int lResVal = sum % 10;
            so_du = (sum >= 10) ? 1 : 0;
            
            if (lResultHead == null) {
                lResultHead = new ListNode(lResVal);
                lResultCur = lResultHead;
            }
            else{
                lResultCur.next = new ListNode(lResVal);
                lResultCur = lResultCur.next;      
            }
            
            if (curPosL1 != null) curPosL1 = curPosL1.next;
            if (curPosL2 != null) curPosL2 = curPosL2.next;
        }
        
        if (so_du == 1) {
            lResultCur.next = new ListNode(1);
        }
        
        return lResultHead;
    }
}