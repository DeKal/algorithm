
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
class mergeKLists {

    private PriorityQueue<ComposeInput> buildBasePriorityQueue(ListNode[] lists) {

        PriorityQueue<ComposeInput> pq = new PriorityQueue<ComposeInput>(lists.length, new ComposeInputComparator());
        for (int i=0; i<lists.length; ++i) {
            if (lists[i] != null){
                pq.add(new ComposeInput(lists[i], i));
            }
        }
        return pq;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        var pq = buildBasePriorityQueue(lists);
        var head = getNext(lists, pq);
        var cur = head;
        while (cur != null) {
            cur.next = getNext(lists, pq);
            cur = cur.next;
        }
        return head;
    }

    ListNode getNext(ListNode[] lists, PriorityQueue<ComposeInput> pq) {
        // FIND MIN USING O(N) ALGO
        // int min = 10001;
        // int minPos = -1;
        // for (int i=0; i<lists.length; ++i) {
        //     if (lists[i] != null) {
        //         ListNode node = lists[i];
        //         if (node.val < min) {
        //             min = node.val;
        //             minPos = i;
        //         }
        //     }
        // }
        // if (minPos == -1) {
        //     return null;
        // }

        if (pq.isEmpty()) {
            return null;
        }
        // FIND MIN USING MIN HEAP
        ComposeInput composeNode = pq.poll();
        int minPos = composeNode.pos;


        var minNode = lists[minPos];
        lists[minPos] =  lists[minPos].next;
        if (lists[minPos] != null) {
            pq.add(new ComposeInput(lists[minPos], minPos));
        }

        return minNode;
    }

    class ComposeInput {
        ListNode node;
        int pos;

        ComposeInput(ListNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    class ComposeInputComparator implements Comparator<ComposeInput>{
        public int compare(ComposeInput input1, ComposeInput input2) {
            if (input1.node.val > input2.node.val)
                return 1;
            else if (input1.node.val < input2.node.val)
                return -1;
            return 0;
        }
    }

}