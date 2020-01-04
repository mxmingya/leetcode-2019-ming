class NQueenII {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public int totalNQueens(int n) {
        return helper(n, 0, 0);
    }
    
    int helper(int n, int row, int count) {
        for (int i = 0; i < n; i++) {
            int curCol = i;
            if (cols.contains(curCol)) {
                continue;
            }
            int curDiag = row + curCol;
            if (diag.contains(curDiag)) {
                continue;
            }
            int curNegDiag = row - curCol;
            if (negDiag.contains(curNegDiag)) {
                continue;
            }
            if (row == n -1) {
                count++;
            } else {
                cols.add(curCol);
                diag.add(curDiag);
                negDiag.add(curNegDiag);
                count = helper(n, row + 1, count);
                cols.remove(curCol);
                diag.remove(curDiag);
                negDiag.remove(curNegDiag);
            }
        }
        return count;
    }
}
