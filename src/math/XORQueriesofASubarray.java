class XORQueriesofASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        if (arr.length == 0 || queries.length == 0) {
            return res;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] compute = queries[i];
            int start = compute[0], end = compute[1];
            int r = arr[start];
            for (int j = start + 1; j <= end; j++) {
                r ^= arr[j];
            }
            res[i] = r;
        }
        return res;
    }
}
