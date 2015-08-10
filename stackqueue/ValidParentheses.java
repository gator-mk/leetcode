import java.util.Stack;
import java.util.HashSet;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        boolean balanced = true;
        HashSet<String> openSet = new HashSet<> ();
        openSet.add ("(");
        openSet.add ("{");
        openSet.add ("[");
        HashMap<String, String> symbolMap = new HashMap<>();
        symbolMap.put (")", "(");
        symbolMap.put ("}", "{");
        symbolMap.put ("]", "[");
        Stack<String> parenStack = new Stack<>();
        for (int i = 0; i < s.length() && balanced == true; i++) {
            String symbol = String.valueOf (s.charAt(i));
            if (openSet.contains (symbol)) {
                parenStack.push (symbol);
            } else {
                if (parenStack.isEmpty ()) balanced = false;
                else {
                    if (matches (symbol, parenStack.peek (), symbolMap)) parenStack.pop ();
                    else balanced = false;
                }
            }
        }
        // to handle case "{[("""
        if (!(balanced && parenStack.empty ())) balanced = false;
        return balanced;
    }
    
    private boolean matches (String s1, String s2, HashMap<String, String> symbolMap) {
        return symbolMap.get(s1).equals(s2);
    }
    
    public static void main (String[] args) {
        ValidParentheses test = new ValidParentheses ();
        String s1 = "[{()}]";
        String s2 = "[";
        System.out.println (test.isValid (s1) + ", " + test.isValid (s2));
    }
}