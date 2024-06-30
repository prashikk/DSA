package RecurssionHard;
import java.util.*;
/*Problem statement
Given an array A of size n and an integer K, return all subsets of A which sum to K.

Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.


Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= n <= 20

Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1 */
public class returnSubSetSumToK {
    public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
		return helper(input,k,0);

	}

	    public static int[][] helper(int input[], int k,int si) {
        if(si==input.length)
        {
            if(k==0)
                return new int[1][0];
            else
                return new int[0][0];
        }
    int op1[][]=helper(input,k-input[si],si+1);////////////
    int op2[][]=helper(input,k,si+1);
    int output[][]=new int[op1.length+op2.length][];////////////////
    int l=0;
    for(int i=0;i<op2.length;i++){
        output[i]=new int[op2[i].length];
        for(int j=0;j<op2[i].length;j++)
            output[l][j]=op2[i][j];////////
        l++;
    }
    for(int i=0;i<op1.length;i++){
        output[i+l]=new int[op1[i].length+1];
        output[i+l][0]=input[si];
        for(int j=1;j<=op1[i].length;j++){
            output[i+l][j]=op1[i][j-1];
        }}
        return output;
    }
    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k1 = 6;
        System.out.println("Input Array 1: " + Arrays.toString(input1));
        System.out.println("K 1: " + k1);
        System.out.println("Subsets that sum to K:");
        int[][] subsets1 = returnSubSetSumToK.subsetsSumK(input1, k1);
        printSubsets(subsets1);

        // Test case 2
        int[] input2 = {1, 2, 3, 4, 5};
        int k2 = 5;
        System.out.println("\nInput Array 2: " + Arrays.toString(input2));
        System.out.println("K 2: " + k2);
        System.out.println("Subsets that sum to K:");
        int[][] subsets2 = returnSubSetSumToK.subsetsSumK(input2, k2);
        printSubsets(subsets2);
    }

    public static void printSubsets(int[][] subsets) {
        for (int[] subset : subsets) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
