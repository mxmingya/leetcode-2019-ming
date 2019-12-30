class AssignCookies.java {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0, j = 0;
        int res = 0;
        for (; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
        }
        return res;
    }
}                       
