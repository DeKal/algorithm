// https://leetcode.com/contest/weekly-contest-283/problems/create-binary-tree-from-descriptions/
public class createBinaryTree {
    class Pair {
        int left;
        int right;
        Pair() {}
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, Pair> maps = new HashMap<>();
        Set<Integer> hasParentSet = new HashSet<>();
        for (int i=0; i<descriptions.length; ++i) {
            if (!maps.containsKey(descriptions[i][0])) {
                var pair = new Pair(-1, -1);
                if (descriptions[i][2] == 1) {
                    pair.left = descriptions[i][1];
                } else {
                    pair.right = descriptions[i][1];
                }
                maps.put(descriptions[i][0], pair);
            } else {
                var pair = maps.get(descriptions[i][0]);
                if (descriptions[i][2] == 1) {
                    pair.left = descriptions[i][1];
                } else {
                    pair.right = descriptions[i][1];
                }
            }
            hasParentSet.add(descriptions[i][1]);
        }
        int rootVal=0;
        for (int i=0; i<descriptions.length; ++i) {
            if (!hasParentSet.contains(descriptions[i][0])) {
                rootVal = descriptions[i][0];
                break;
            }
        }

        TreeNode root = new TreeNode();
        root.val = rootVal;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currentNode = q.poll();
            System.out.println(currentNode.val);

            Pair pair = maps.get(currentNode.val);
            if (pair == null) {
                continue;
            }
            if (pair.left != -1) {
                currentNode.left = new TreeNode();
                currentNode.left.val = pair.left;
                q.add(currentNode.left);
            }
            if (pair.right != -1) {
                currentNode.right = new TreeNode();
                currentNode.right.val = pair.right;
                q.add(currentNode.right);
            }
        }

        return root;

    }
}
