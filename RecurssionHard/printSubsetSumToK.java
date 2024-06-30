package RecurssionHard;
import java.util.*;
/*Problem statement
Given an array A and an integer K, print all subsets of A which sum to K.

Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.


Note :
The order of subsets are not important. Just print them in different lines.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input:
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output:
3 3
5 1 */
public class printSubsetSumToK {
    public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
		 int output[]=new int[0];
        helper(input,0,k,output);
		
	}
	    public static void helper(int input[],int si,int k,int output[]){
        if(si==input.length){
            if(k==0)
            {
                for(int i=0;i<output.length;i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
                return;
            }
            else
                return;
        }
        helper(input,si+1,k,output);
        int newoutput[]=new int[output.length+1];
        int i=0;
        for( ;i<output.length;i++)
        {
            newoutput[i]=output[i];
        }
            newoutput[i]=input[si];
        helper(input,si+1,k-input[si],newoutput);
  
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k1 = 6;
        System.out.println("Test Case 1:");
        System.out.println("Input Array: " + Arrays.toString(arr1));
        System.out.println("Subset Sums to " + k1 + ":");
        printSubsetSumToK.printSubsetsSumTok(arr1, k1);
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 5;
        System.out.println("Test Case 2:");
        System.out.println("Input Array: " + Arrays.toString(arr2));
        System.out.println("Subset Sums to " + k2 + ":");
        printSubsetSumToK.printSubsetsSumTok(arr2, k2);
    }
}
