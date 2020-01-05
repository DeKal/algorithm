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
int kthSmallestInBST(Tree<Integer> t, int k) {
    FindKthSmallestAlgo algo = new FindKthSmallestAlgo(t,k);
    return algo.findKthSmallestInBST();
}

class FindKthSmallestAlgo{
    private Tree<Integer> root = null;
    private int k;
    private int kthVal;
    public FindKthSmallestAlgo(Tree<Integer> t, int k){
        root = t;
        this.k = k;
    }
    
    public int findKthSmallestInBST(){
        if (root == null)
            return -1;
        traverse(root, 0);
        return kthVal;
    }
    
    private int traverse(Tree<Integer> root, int numOfLeftNode){
        if (root == null)
            return 0;
        int numLeft = traverse(root.left, numOfLeftNode);
        numOfLeftNode = numOfLeftNode + numLeft + 1;
        if (numOfLeftNode == k)
        {
            kthVal = root.value;
        }
        int numRight = traverse(root.right, numOfLeftNode);
        return numLeft + numRight + 1;
        
    }
}