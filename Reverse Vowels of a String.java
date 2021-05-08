public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(s.charAt(i))) ++i;
            while (i < j && !isVowel(s.charAt(j))) --j;
            swap(chs, i, j);
            ++i;
            --j;
        }
        return new String(chs);
    }
    private boolean isVowel(char c) {
        return "aeiou".contains(String.valueOf(Character.toLowerCase(c)));
    }
    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
