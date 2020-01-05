// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> lCur = l;
    ListNode<Integer> lPrev = null;
    while (lCur != null){
        ListNode<Integer> lNext = lCur.next; 
        if (lCur.value ==k){
            if (lPrev == null){
                l = lNext;    
            }
            else{
                lPrev.next = lNext;
            }
            lCur.next = null;
            
        }
        if (lCur.next != null)
            lPrev = lCur;
        lCur = lNext;
    }
    return l;
}