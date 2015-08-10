import java.util.List;
import java.util.ArrayList;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> trav = new ArrayList<>();
        postTrav (root, trav);
        return trav;
    }
    
    private void postTrav (TreeNode root, ArrayList<Integer> trav) {
        if (root == null) return;
        postTrav (root.left, trav);
        postTrav (root.right, trav);
        trav.add (root.val);
    }
    
    public static void main (String[] args) {
        PostorderTraversal test = new PostorderTraversal();
        TreeNode root = new TreeNode (2);
        root.left = new TreeNode (7);
        root.right = new TreeNode (5);
        StringBuilder result = new StringBuilder ();
        List<Integer> resultList = test.postorderTraversal (root);
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