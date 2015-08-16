class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum {
    /**
    * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
    * such that adding up all the values along the path equals the given sum.
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        else return (hasPathSum (root.left, sum - root.val) || hasPathSum (root.right, sum - root.val));
    }
    
    public static void main (String[] args) {
        PathSum test = new PathSum ();
        TreeNode root1 = new TreeNode (4);
        root1.left = new TreeNode (3);
        root1.right = new TreeNode (5);
        root1.left.left = new TreeNode (6);
        root1.left.left.right = new TreeNode (7);
        System.out.println (test.hasPathSum (root1, 9));
        TreeNode root2 = new TreeNode (4);
        root2.left = new TreeNode (2);
        root2.right = new TreeNode (5);
        System.out.println (test.hasPathSum (root2, 6));
    }
}