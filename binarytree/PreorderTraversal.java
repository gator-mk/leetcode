import java.util.List;
import java.util.ArrayList;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> trav = new ArrayList<>();
        preTrav (root, trav);
        return trav;
    }
    
    private void preTrav (TreeNode root, ArrayList<Integer> trav) {
        if (root == null) return;
        trav.add (root.val);
        preTrav (root.left, trav);
        preTrav (root.right, trav);
    }
    
    public static void main (String[] args) {
        PreorderTraversal test = new PreorderTraversal();
        TreeNode root = new TreeNode (2);
        root.left = new TreeNode (7);
        root.right = new TreeNode (5);
        StringBuilder result = new StringBuilder ();
        List<Integer> resultList = test.preorderTraversal (root);
        for (int entry: resultList) {
            result.append (entry);
        }
        System.out.println(result);
    }
}
    
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}