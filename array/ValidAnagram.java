import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray ();
        char[] charT = t.toCharArray ();
        Arrays.sort (charS);
        Arrays.sort (charT);
        String sortedS = new String (charS);
        String sortedT = new String (charT);
        return (sortedS.equals (sortedT));
    }
    
    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram ();
        System.out.println (test.isAnagram("ana", "naa"));
    }
}