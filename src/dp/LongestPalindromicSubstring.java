class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len  = s.length();
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[i][j] || isPalindrome(s, i, j)) {
                    dp[i][j] = true;
                    if (j-i+1 > res.length()) {
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        
        return res;
    }
    
    boolean isPalindrome(String s, int i, int j) {
        // j inclusive
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
