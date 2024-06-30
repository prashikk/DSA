package TwoDArrays;
/*Problem statement
For a given two-dimensional integer array/list of size (N x M), print the array/list in a sine wave order, i.e, print the first column top to bottom, next column bottom to top and so on.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
3 4 
1  2  3  4 
5  6  7  8 
9 10 11 12
Sample Output 1:
1 5 9 10 6 2 3 7 11 12 8 4
Sample Input 2:
2
5 3 
1 2 3 
4 5 6 
7 8 9 
10 11 12 
13 14 15
3 3
10 20 30 
40 50 60
70 80 90
Sample Output 2:
1 4 7 10 13 14 11 8 5 2 3 6 9 12 15 
10 40 70 80 50 20 30 60 90  */
public class printLikeAWave {
    public static void wavePrint(int[][] mat) {
        int n = mat.length;
        if (n == 0) {
            return;
        }
        
        int m = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // Top to bottom for even indexed columns
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[j][i] + " ");
                }
            } else {
                // Bottom to top for odd indexed columns
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(mat[j][i] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        wavePrint(mat1); // Output: 1 5 9 10 6 2 3 7 11 12 8 4
    }
}
