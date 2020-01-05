// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//

ListNode<Integer> reverse(ListNode<Integer> head) {
    ListNode<Integer> current = head;
    ListNode<Integer> prev = null;
    while (current != null){
        ListNode<Integer> next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
int getNodeVal(ListNode<Integer> node){
    if (node == null) return 0;
    return node.value;
}
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    ListNode<Integer> aRev = reverse(a);
    ListNode<Integer> bRev = reverse(b);
    ListNode<Integer> result = null;
    ListNode<Integer> current = null;
    int du = 0;
    while (aRev != null || bRev != null){
        int aVal = getNodeVal(aRev);
        int bVal = getNodeVal(bRev);
        
        ListNode<Integer> newNode = new ListNode((aVal + bVal + du) %10000);
        if (current != null){
            current.next = newNode;
        }
        else{
            result = newNode;
        }
        current = newNode;
        du = (aVal + bVal + du) /10000;
        
        if (aRev != null) aRev = aRev.next;
        if (bRev != null) bRev = bRev.next;
    }
    if (du == 1)
        current.next = new ListNode(1);
    return  reverse(result);
}