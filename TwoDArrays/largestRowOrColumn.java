package TwoDArrays;
/*Problem statement
For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest sum(sum of all the elements in a row or column) amongst all the rows/columns.

Note :
If there are more than one rows/columns with maximum sum, consider the row/column that comes first. And if ith row and jth column has the same largest sum, consider the ith row as answer.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= t <= 10^2
1 <= N <= 10^3
1 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
3 2
6 9 
8 5 
9 2 
Sample Output 1:
column 0 23
Sample Input 2:
1
4 4
6 9 8 5 
9 2 4 1 
8 3 9 3 
8 7 8 6 
Sample Output 2:
column 0 31 */
public class largestRowOrColumn {

    public static void findLargest(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int largestRow = Integer.MIN_VALUE;
        int rn = -1;
        
        // Find row with largest sum
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += mat[i][j];
            }
            if (sum > largestRow) {
                largestRow = sum;
                rn = i;
            }
        }
        
        int largestCol = Integer.MIN_VALUE;
        int cn = -1;
        
        // Find column with largest sum
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mat[i][j];
            }
            if (sum > largestCol) {
                largestCol = sum;
                cn = j;
            }
        }
        
        // Compare and print the result
        if (largestRow >= largestCol) {
            System.out.println("row " + rn + " " + largestRow);
        } else {
            System.out.println("column " + cn + " " + largestCol);
        }
    }
    public static void main(String[] args) {
        int[][] mat1 = {
            {6, 9},
            {8, 5},
            {9, 2}
        };
        findLargest(mat1);
        
    }
}
