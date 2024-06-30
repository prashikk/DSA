package TwoDArrays;
/*Problem statement
For a given two-dimensional integer array/list of size (N x M), find and print the sum of each of the row elements in a single line, separated by a single space.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
4 2 
1 2 
3 4 
5 6 
7 8
Sample Output 1:
3 7 11 15 
Sample Input 2:
2
2 5 
4 5 3 2 6 
7 5 3 8 9
4 4
1 2 3 4
9 8 7 6
3 4 5 6
-1 1 -10 5
Sample Output 2:
20 32 
10 30 18 -5  */
public class rowWiseSum {

    public static void rowWiseSum(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int rSum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                rSum += mat[i][j];
            }
            System.out.print(rSum + " ");
        }
        System.out.println(); 
    }
    public static void main(String[] args) {
        int[][] testCase1 = {
            {1, 2},
            {3, 4},
            {5, 6},
            {7, 8}
        };
        rowWiseSum(testCase1);
        
    }
}
