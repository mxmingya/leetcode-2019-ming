class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 ) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] mSum = new int[m+1][n+1];
        mSum[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int res = mSum[0][0];
        
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    mSum[i][j] = Math.min(Math.min(mSum[i-1][j], mSum[i][j-1]), mSum[i-1][j-1]) + 1;
                    // System.out.printf("i: %d, j:%d, val: %d\n", i, j, mSum[i][j]);
                    res = mSum[i][j] > res ? mSum[i][j] : res;
                }
            }
        }
        
        return res * res;
    }
}
