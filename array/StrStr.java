public class StrStr {
    /**
    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    */
    public int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack == null || needle == null) return 0;
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int k = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    if (j == needle.length() - 1) return i;
                    k++;
                }
                else {
                    break;
                }
            }
        }
        return -1;
    }
    
    public static void main (String[] args) {
        StrStr test = new StrStr();
        System.out.println (test.strStr ("abcdef", "ef"));
    }
}