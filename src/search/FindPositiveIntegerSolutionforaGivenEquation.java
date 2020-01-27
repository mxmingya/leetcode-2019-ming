/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class FindPositiveIntegerSolutionforaGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
         List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while ( x <= 1000 && y > 0) {
            int result = customfunction.f(x,y);
            if (result < z) {
                x++;
            } else if (result > z) {
                y--;
            } else {
                System.out.printf("%d %d \n", x, y);
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                res.add(temp);
                x++;
                y--;
            }
        }
        return res;
    }
}
