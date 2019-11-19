class WordBreak.java {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict.size() == 0) {
            return false;
        }
        int len = s.length();
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[len+1];
        // dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (i == 0 || dp[i-1]) {
                for (int j = i+1; j <= len; j++) {
                    String curWord = s.substring(i, j);
                    if (set.contains(curWord)) {
                        dp[j-1] = true;
                    }
                }
            }
        }
        
        return dp[len-1];
    }
}
