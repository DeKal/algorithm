// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//

ListNode<Integer> findMiddleNode(ListNode<Integer> headNode) 
{ 
    ListNode<Integer> prev_slow_ptr = null;
    ListNode<Integer> slow_ptr = headNode; 
    ListNode<Integer> fast_ptr = headNode;
    
    if (headNode != null) 
    {
        int length = 0;
        while (fast_ptr != null && fast_ptr.next != null) 
        { 
            length += 2;
            if (fast_ptr.next.next == null)
                length--;
            fast_ptr = fast_ptr.next.next; 
            prev_slow_ptr = slow_ptr;
            slow_ptr = slow_ptr.next;
        } 
        if (length%2 !=0)
            return prev_slow_ptr;
        else
            return slow_ptr;
    } 
    return null;
} 



void reverse(ListNode<Integer> node){
    ListNode<Integer> curNode = node.next;
    ListNode<Integer> prevNode = null;
    while (curNode != null){
        ListNode<Integer> nextNode = curNode.next;
        curNode.next = prevNode;
        prevNode = curNode;
        curNode = nextNode;
    }
    node.next = prevNode;
}


boolean checkPalindrome(ListNode<Integer> headNode, ListNode<Integer> middleNode){
    middleNode = middleNode.next;
    while (middleNode != null){
        if (!headNode.value.equals(middleNode.value)){   
           return false;
        }
        //System.out.println("Node Compare: " + headNode.value + " " + middleNode.value);
        headNode = headNode.next;
        middleNode = middleNode.next;
    }
    return true;
}

    
boolean isLP(ListNode<Integer> headNode){
    ListNode<Integer> middleNode = findMiddleNode(headNode);
    if (middleNode == null)
        return true;
    System.out.println("Middle Node: " + middleNode.value);
    reverse(middleNode);
    boolean isLP = checkPalindrome(headNode, middleNode);
    reverse(middleNode);
    return isLP;
}    


boolean isListPalindrome(ListNode<Integer> l) {
    if (l != null)
        return isLP(l);
    else
        return true;
}