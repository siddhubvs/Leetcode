class Solution {
        public String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; --i, --j) {
            int sum = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + c;
            c = sum / 2;
            sb.append(sum % 2);
        }
        if (c != 0) sb.append(c);
        return sb.reverse().toString();
    

    }
}
