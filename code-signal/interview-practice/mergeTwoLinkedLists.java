// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    
    ListNode<Integer> result = new ListNode<Integer>(0);
    ListNode<Integer> cur = result;
    while (l1 != null && l2 !=null){
        if (l1.value < l2.value)
        {
            cur.next = l1;
            cur = l1;
            l1 = l1.next;
        }
        else{
            cur.next = l2;
            cur = l2;
            l2 = l2.next;
        }
    }
    if (l2 != null)
        cur.next = l2;
    if (l1 != null)
        cur.next = l1;
    
    return result.next;
}