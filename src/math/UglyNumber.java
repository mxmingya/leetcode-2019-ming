class UglyNumber {
    public boolean isUgly(int num) {

        int[] nums = {2,3,5};
        
        for (int n : nums) {
            while (num > 0 && num % n == 0) {
                num = num / n;
            }
        }
        
        return num == 1;
    }
}
