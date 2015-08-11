class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaxDepth {
    /**
    * Given a binary tree, find its maximum depth.
    * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth (root.left);
        int rightDepth = maxDepth (root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
    
    public static void main (String[] args) {
        MaxDepth test = new MaxDepth ();
        TreeNode root = new TreeNode (4);
        root.left = new TreeNode (3);
        root.right = new TreeNode (5);
        root.left.left = new TreeNode (6);
        root.left.left.right = new TreeNode (7);
        System.out.println (test.maxDepth(root) == 4);
    }
}