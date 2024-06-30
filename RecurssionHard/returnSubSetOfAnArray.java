package RecurssionHard;
import java.util.*;
/*Problem statement
Given an integer array (of length n), find and return all the subsets of input array.

NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12  */
public class returnSubSetOfAnArray {
    public static int[][] subsets(int input[]) {
		// Write your code here
		        return subsets(input,0);


	}
	  public static int[][] subsets(int input[],int si) {
        if(si>=input.length)
        {
            int ans[][]=new int[1][0];
            return ans;
        }
        int[][] smallans=subsets(input,si+1);
        int[][] ans=new int[smallans.length*2][];
        int k=0;
        for(int i=0;i<smallans.length;i++){
            ans[i]=new int[smallans[i].length];
            for(int j=0;j<smallans[i].length;j++){
                ans[i][j]=smallans[i][j];
            }
            k++;
        }
        for(int i=0;i<smallans.length;i++)
        { ans[k+i]=new int[smallans[i].length+1];
          ans[k+i][0]=input[si];
            for(int j=1;j<=smallans[i].length;j++)
            {
                ans[i+k][j]=smallans[i][j-1];
            } 
       
        }
        return ans;


}
public static void main(String[] args) {
    // Test case
    int[] input = {15, 20, 12};
    System.out.println("Input Array: " + Arrays.toString(input));
    System.out.println("Subsets of the input array:");
    int[][] subsets = returnSubSetOfAnArray.subsets(input);
    printSubsets(subsets);
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
