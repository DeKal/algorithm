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
boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    return traverseTree(t, 0, s);
}

boolean traverseTree(Tree<Integer> t, int currentSum, int s){
    if (t == null)
        return false;
    
    boolean result = false;
    currentSum += t.value;
    
    if (t.left != null)
        result |= traverseTree(t.left, currentSum, s);
    
    if (t.right != null)
        result |= traverseTree(t.right, currentSum, s);
    
    if (t.left == null && t.right == null) {
        if (currentSum == s)
            return true;
        else
            return false;
    }
    else
        return result;
}