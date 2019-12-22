class ArrangeCoins {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            n -= i;
            res++;
            if (n <= i) {
                return res;
            }
        }
        return res;
    }
    // if n == 8, 7, 5,2,-2
    // res = 0,1 , 2, 3,4
}
