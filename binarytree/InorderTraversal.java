import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> trav = new ArrayList<Integer>();
        inTrav (root, trav);
        return trav;
    }
    
    private void inTrav (TreeNode root, List<Integer> trav) {
        if (root == null) return;
        inTrav (root.left, trav);
        trav.add (root.val);
        inTrav (root.right, trav);
    }
    
    public static void main (String[] args) {
        InorderTraversal test = new InorderTraversal();
        TreeNode root = new TreeNode (2);
        root.left = new TreeNode (7);
        root.right = new TreeNode (5);
        StringBuilder result = new StringBuilder ();
        List<Integer> resultList = test.inorderTraversal (root);
        for (int entry: resultList) {
            result.append (entry);
        }
        System.out.println(result);
    }
}