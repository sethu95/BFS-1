// Time Complexity: O(n)
// Space Complexity: O(H)

// We perform a dfs recursively on the tree, we keep storing the elements in their respective levels using a global list of list

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;

        dfs(root, 0);

        return result;
    }

    public void dfs(TreeNode root, int lvl) {
        if (root == null) return;

        if (lvl == result.size()) result.add(new ArrayList<>());

        result.get(lvl).add(root.val);

        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}

// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if (root == null) return new ArrayList<>();
        
//         List<List<Integer>> result = new ArrayList<>();

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             int len = queue.size(); // to note how many elements are in each level
//             List<Integer> levelOrder = new ArrayList<>();
//             for (int i=0; i<len; i++) {
//                 TreeNode node = queue.poll();
//                 levelOrder.add(node.val);
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
//             result.add(levelOrder);
//         }

//         return result;
//     }
// }
