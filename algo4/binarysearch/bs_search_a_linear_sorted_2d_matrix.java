/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 *
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/search-a-2d-matrix/}
 * [Difficulty] - Easy
 *
 */
public class bs_search_a_linear_sorted_2d_matrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length,
            n = matrix[0].length,
            l = 0,
            r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2,
                row = mid / n,
                col = mid % n,
                val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
