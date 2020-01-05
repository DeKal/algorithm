//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
boolean isTreeSymmetric(Tree<Integer> t) {
    if (t != null)
        return isSame(t.left, t.right);
    else
        return true;
}

boolean isSame(Tree<Integer> left, Tree<Integer> right){
    if (left == null && right == null)
        return true;
    else if (left == null || right == null){
        return false;
    }
    
    if (!left.value.equals(right.value)){
        return false;
    }
    return isSame(left.left, right.right) && isSame(left.right, right.left);
}