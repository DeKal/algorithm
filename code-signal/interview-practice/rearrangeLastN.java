// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
//
int getLength(ListNode<Integer> node){
    int length = 0;
    while (node !=  null){
        ++length;
        node = node.next;
    }
    return length;
}

ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    int length = getLength(l);
    int count = 0;
    ListNode<Integer> newHead = l;
    ListNode<Integer> prevNode = null;
    while (count++ < length-n){
        prevNode = newHead;
        newHead = newHead.next;
    }
 
    if (newHead != null && newHead != l){
        prevNode.next = null;
        ListNode<Integer> tail = newHead;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = l;
        return newHead;
    }
    return l;
}