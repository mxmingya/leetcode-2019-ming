class letterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(S, res, sb, 0);
        return res;
    }
    
    void dfs(String S, List<String> res, StringBuilder sb, int index) {
        if (index == S.length() || sb.length() == S.length()) {
            res.add(sb.toString());
            return;
        }
        
        char curLetter = S.charAt(index);
        if (Character.isDigit(curLetter)) {
            sb.append(curLetter);
            dfs(S, res, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(Character.toUpperCase(curLetter));
            dfs(S, res, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toLowerCase(curLetter));
            dfs(S, res, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
