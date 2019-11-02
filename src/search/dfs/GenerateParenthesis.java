class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(n, res, new StringBuilder(), 0, 0);
        return res;
    }
    
    void dfs(int n, List<String> res, StringBuilder sb, int l, int r) {
        
        
        if (l+r==2*n) {
            if (l == r) {
                res.add(sb.toString());
            }
            return;
        }
        
        if (l < r) {
            return;
        }
        
        sb.append("(");
        dfs(n, res, sb, l+1 ,r);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append(")");
        dfs(n, res, sb, l, r+1);
        sb.deleteCharAt(sb.length()-1);
        
    }
}
