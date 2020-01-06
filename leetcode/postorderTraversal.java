/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> result = new LinkedList<>();;
     
        TreeNode t = root;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty() && root!=null){
            root = stack.peek();
            //nodes without children should be printed 
            if( (root.left==null&&root.right==null) 
             || (t==root.left||t==root.right) ){//or nodes whose children have already been printed 
                result.add(root.val);
                stack.pop();
                t = root;
            }else{
                if(root.right!=null) stack.push(root.right);
                if(root.left!=null) stack.push(root.left);
            }
        }
        return result;
    }
}