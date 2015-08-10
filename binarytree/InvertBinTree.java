class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class InvertBinTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        else {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            
            root.left = right;
            root.right = left;
        }
        return root;
    }
    
    private void printTree(TreeNode node) {
        if (node == null) return;
        // left, node itself, right
        printTree(node.left);
        System.out.print(node.val + "  ");
        printTree(node.right);
    }
    
    public static void main (String[] args) {
        InvertBinTree test = new InvertBinTree ();
        TreeNode root = new TreeNode (4);
        root.left = new TreeNode (3);
        root.right = new TreeNode (5);
        test.printTree (root);
        System.out.println ();
        root = test.invertTree (root);
        test.printTree (root);
        System.out.println ();
    }
}