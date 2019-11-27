class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        return Math.abs(s.length() - t.length()) >= 2 || s.equals(t) ? false : isOneEditDistance(s, t, true);
    }
    public boolean isOneEditDistance(String s, String t, boolean flag) {
        
        int sLen = s.length(), tLen = t.length();
        
        int i = 0, j = 0;
        for (; i < sLen && j < tLen; i++, j++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!flag) {
                    return false;
                }
                if (sLen == tLen + 1) {
                    // System.out.printf("%s %s \n", s.substring(i+1), t.substring(i));
                    return isOneEditDistance(s.substring(i+1), t.substring(i), false);
                }
                else if (sLen == tLen - 1) {
                    // System.out.printf("%s %s \n", s.substring(i), t.substring(i+1));
                    return isOneEditDistance(s.substring(i), t.substring(i+1), false);
                }
                else if (sLen == tLen) {
                    // System.out.printf("%s %s \n", s.substring(i+1), t.substring(i+1));
                    return isOneEditDistance(s.substring(i+1), t.substring(i+1), false);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
