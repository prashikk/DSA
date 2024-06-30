package TwoDArrays;
/*Problem statement
For a given two-dimensional square matrix of size (N x N). Find the total sum of elements on both the diagonals and at all the four boundaries.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1sec
Sample input 1:
1
3
1 2 3
4 5 6
7 8 9
Sample Output 1:
45
Explanation for Sample Output 1:
The boundary elements are 1, 2, 3, 6, 9, 8, 7 and 4. 

The first-diagonal elements are 1, 5 and 9. 

The second-diagonal elements are 3, 5 and 7.

We just need to add all these numbers making sure that no number is added twice. For example, '1' is both a boundary element and a first-diagonal element similarly, '5' contributes to both the diagonals but they won't be added twice.

Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the output.
Sample input 2:
2
5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
4
1 2 3 10
4 5 6 11
7 8 9 12
13 14 15 16
Sample Output 2:
273
136 */
public class totalSumOfBoundariesAndDiagonal {

  
    public static void totalSum(int[][] mat) {
       		
			int n=mat.length;
            int sum=0;
        for(int i=0 ; i<n ; i++) {
            sum=sum+mat[0][i];
            sum=sum+mat[n-1][i];
        }
        
        for(int j=1;j<n-1;j++) {
            sum=sum+mat[j][0];
            sum=sum+mat[j][n-1];
        }
        
        for(int k=1;k<n-1;k++) {
            sum=sum+mat[k][k];
            sum=sum+mat[k][n-1-k];
        }
            
            if(n%2!=0) {
                sum=sum-mat[n/2][n/2];
            }
            
            System.out.print(sum);
    
        
    }
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        totalSum(mat1); // Output: 45
    }
}
