package search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // 把二维matrix转化为一维的array
        int left = 0, right = matrix.length * matrix[0].length - 1;
        int numOfCol = matrix[0].length;
        while (left  <  right) {
            int mid = left + ( right - left) / 2;
            int row = mid / numOfCol, col = mid % numOfCol;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {4,5,6};
        int[] a3 = {7,8,9};
        int[][] a = {a1, a2, a3};
        System.out.println(new Search2DMatrix().searchMatrix(a, 7));
        int[] a4 = {1,1};
        int [][] arr2 = {a4};
        System.out.println(new Search2DMatrix().searchMatrix(arr2, 2));
    }
}
