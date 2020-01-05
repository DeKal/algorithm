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
boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null)  
        return true; 
    if (t1 == null) 
        return false; 
    
    if (areIdentical(t1, t2))  
        return true; 

    return isSubtree(t1.left, t2) || isSubtree(t1.right, t2); 
}

boolean areIdentical(Tree<Integer> root1, Tree<Integer> root2) { 
   
    if (root1 == null && root2 == null) 
        return true; 
   
    if (root1 == null || root2 == null) 
        return false; 
   
    return (root1.value.equals(root2.value) 
            && areIdentical(root1.left, root2.left) 
            && areIdentical(root1.right, root2.right)); 
}