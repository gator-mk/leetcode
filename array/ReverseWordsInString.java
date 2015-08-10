import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        final String pattern = "[ ]{2,}";    // find 2 or more adjacent spaces
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        s = m.replaceAll(" ");
        String[] words = s.split (" ");
        StringBuilder temp = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            temp.append (words[i]);
            if (i != 0) temp.append(" ");
        }
        return temp.toString();
    }
    
    public static void main (String[] args) {
        ReverseWordsInString test = new ReverseWordsInString ();
        System.out.println (test.reverseWords (" Am   I insane?"));
    }
}