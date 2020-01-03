class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        search(n, new ArrayList<>(), res);
        return res;
    }
    
    void search(int n, List<Integer> cols, List<List<String>> res) {
        if (cols.size() == n) {
            res.add(draw(n, cols));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (valid(n, cols, i)) {
                cols.add(i);
                search(n, cols, res);
                cols.remove(cols.size()-1);
            }
        }
    }
    
    List<String> draw(int n, List<Integer> cols) {
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curCol = cols.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == curCol ? 'Q' : '.');
            }
            list.add(sb.toString());
        }
        return list;
    }
    
    boolean valid(int n, List<Integer> cols, int col) {
        int size = cols.size();

        for (int row = 0; row < size; row++) {
            int pre = cols.get(row);
            if (pre == col) {
                return false;
            }
            if (pre - row == col - size) {
                return false;
            }

            if (pre + row == col + size) {
                return false;
            }
        }
        return true;
    }
    
    
}
