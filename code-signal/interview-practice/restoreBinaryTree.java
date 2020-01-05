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
Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
    Map<Integer, Integer> mapNodeValToPos = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i){
        mapNodeValToPos.put(inorder[i], i);
    }
    Tree<Integer> treeRoot = new Tree<>(preorder[0]);
    
    for (int i = 1; i < preorder.length; ++i){
        Tree<Integer> currentNode = treeRoot;
        while (currentNode != null){
            boolean isLeft = mapNodeValToPos.get(preorder[i]) < mapNodeValToPos.get(currentNode.value);
            if (isLeft){
                if (currentNode.left == null){
                    currentNode.left = new Tree<>(preorder[i]);
                    currentNode = null;
                }
                else{
                    currentNode = currentNode.left;
                }
            }
            else{
                if (currentNode.right == null){
                    currentNode.right = new Tree<>(preorder[i]);
                    currentNode = null;
                }
                else{
                    currentNode = currentNode.right;
                }
            }
        }
        
    }
    
    return treeRoot;
}
