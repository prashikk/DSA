package TwoDArrays;
/*Problem statement
For a given two-dimensional integer array/list of size (N x M), print it in a spiral form. That is, you need to print in the order followed for every iteration:

a. First row(left to right)
b. Last column(top to bottom)
c. Last row(right to left)
d. First column(bottom to top)
 Mind that every element will be printed only once.

Refer to the Image:
Spiral path of a matrix

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
4 4 
1 2 3 4 
5 6 7 8 
9 10 11 12 
13 14 15 16
Sample Output 1:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Sample Input 2:
2
3 3 
1 2 3 
4 5 6 
7 8 9
3 1
10
20
30
Sample Output 2:
1 2 3 6 9 8 7 4 5 
10 20 30  */
public class printSpiral {
    public static void spiralPrint(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        
        int rS = 0, rE = n - 1, cS = 0, cE = m - 1;
        int count = 0;
        int noElem = n * m;
        
        while (count < noElem) {
            // Print top row left to right
            for (int c = cS; c <= cE && count < noElem; c++) {
                System.out.print(matrix[rS][c] + " ");
                count++;
            }
            rS++;
            
            // Print right column top to bottom
            for (int r = rS; r <= rE && count < noElem; r++) {
                System.out.print(matrix[r][cE] + " ");
                count++;
            }
            cE--;
            
            // Print bottom row right to left
            for (int c = cE; c >= cS && count < noElem; c--) {
                System.out.print(matrix[rE][c] + " ");
                count++;
            }
            rE--;
            
            // Print left column bottom to top
            for (int r = rE; r >= rS && count < noElem; r--) {
                System.out.print(matrix[r][cS] + " ");
                count++;
            }
            cS++;
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        spiralPrint(mat1); // Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        
    }
}
