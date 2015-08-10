public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        if (Character.toString(s.charAt(s.length() - 1)).equals (" ")) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.toString(s.charAt(i)).equals (" ")) break;
            count++;
        }
        return count;
    }
    
    public static void main (String[] args) {
        LengthOfLastWord test = new LengthOfLastWord ();
        System.out.println (test.lengthOfLastWord (" "));
        System.out.println (Character.toString(" ".charAt(0)).equals(" "));
    }
}