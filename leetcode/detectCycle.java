
// https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class detectCycle {
    // Brute force O(n^2)
    public ListNode detectCycleV1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (head == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        if (fast != slow) {
            return null;
        } else if (head == slow) {
            return head;
        }

        ListNode cur = head;
        ListNode circleCur = slow;

        while (cur != slow) {
            do {
                if (circleCur != cur) {
                    circleCur = circleCur.next;

                } else {
                    return cur;
                }
            } while(circleCur != slow);

            cur = cur.next;
        }
        return cur;
    }

    // Based on binary search to find the entrance O(nlogn)
    public ListNode detectCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (head == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        if (fast != slow) {
            return null;
        } else if (head == slow) {
            return head;
        }

        int apprDistanceToLoop = 0;
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            apprDistanceToLoop++;
        }
        // System.out.println(apprDistanceToLoop);
        // System.out.println("-------");
        int min = 0;
        int max = apprDistanceToLoop;

        while (min < max-1) {
            int middle = (min + max) /2;
            // System.out.println(middle);
            int tmpCount = 0;

            cur = getNodePosK(middle, head);
            // System.out.println("Cur " + cur.val);

            if (isInLoop(cur, slow)) {
                max = middle;
            } else {
                min = middle;
            }
        }
        cur = getNodePosK(min, head);
        if (isInLoop(cur, slow)) {
            return cur;
        } else {
            return cur.next;
        }

    }

    private ListNode getNodePosK(int pos, ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (count < pos) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private boolean isInLoop(ListNode cur, ListNode loopHead) {
        ListNode circleCur = loopHead;
        do {
            if (circleCur != cur) {
                circleCur = circleCur.next;
            } else {
                return true;
            }
        } while(circleCur != loopHead);

        return false;
    }

    // Based on the observation that after meeting point
    // If from meeting point and the start point
    // we start to run together, the new meeting point would be the start of the circle
    // Distance from head to start of cicle = x
    // Distance from start of cicle to meeting point = y
    // slow = a = x + y
    // fast = 2a = 2(x+y)
    // => x+y = C*n (C is lenght of the cycle and n is number of round)
    // => slow is already has y step into the circle
    // => after x step (x+y = C*n), slow will be at the start of the circle
    // => after x step from head, also reach start of the cicle
    // => from head and meeting point go x step, they would meet at the start of the circle
    // O(n)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (head == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        if (fast != slow) {
            return null;
        } else if (head == slow) {
            return head;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

}
