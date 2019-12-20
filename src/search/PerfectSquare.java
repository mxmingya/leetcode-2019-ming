class PerfectSquare {
    public boolean isPerfectSquare(int num) {
         int start = 1, end = num;

        while (start <= end) {
            long mid = start + (end - start)/2;
            
            if (mid * mid == num) {
                return true;
            }
            else if (mid * mid < num) {
                start = (int) mid + 1;
            }
            else if (mid * mid > num) {
                end = (int) mid - 1;
            }
        }
        // start = 4, 
        // end = 7, 4
        // mid = 5,
        return false;
    }
}
