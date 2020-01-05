// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//

int getLength(ListNode<Integer> node){
    int length = 0;
    while (node !=  null){
        ++length;
        node = node.next;
    }
    return length;
}

ListNode<Integer> findSecondHead(ListNode<Integer> l, int k){
    
    for (int i=0; i < k - 1 ; ++i){
        l = l.next;
    }
    ListNode<Integer> next = l.next;
    l.next = null;
    return next;
}

ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    
    int length = getLength(l);
    ListNode<Integer> curNode = l;
    ListNode<Integer> prevNode = null;
    int count = 0;
    while (curNode != null && ++count <= length - length % k){
        ListNode<Integer> nextNode = curNode.next;
        curNode.next = prevNode;
        prevNode = curNode;
        curNode = nextNode;
    }
    ListNode<Integer> rL = prevNode;
    ListNode<Integer> remainL = curNode;
    
    ListNode<Integer> secondHead = findSecondHead(rL, k) ;
  
    ListNode<Integer> firstHead = rL;
    
    while (secondHead != null) {
        ListNode<Integer> prevSecondHead = secondHead;
        for (int i=0; i< k-1; ++i){
            secondHead = secondHead.next;
        } 
        ListNode<Integer> next = secondHead.next;
        secondHead.next = firstHead;
        firstHead = prevSecondHead;
        secondHead = next;
    }
    while (rL.next != null){
        rL = rL.next;
    }
    rL.next = remainL;
    return firstHead;
    
}