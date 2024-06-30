package Recursion;
/*Problem statement
Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.

Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.

You should start traversing your array from 0, not from (N - 1).

Do this recursively. Indexing in the array starts from 0.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
3 */
public class lastIndex {

    public static int find(int arr[],int x,int li) {
		
		if(li==0) {
			return -1;
		}
		if(arr[li]==x) {
			return li;
		}
		
		int result=find(arr,x,li-1);
		return result;
		
	}

	public static int lastIndex(int input[], int x) {
		return find(input,x,input.length-1);
	}
    public static void main(String[] args) {
        int[] arr1 = {9, 8, 10, 8};
        int[] arr2 = {9, 8, 10, 8};
        
        System.out.println(lastIndex(arr1, 8)); // Output: 3
        System.out.println(lastIndex(arr2, 2)); // Output: -1
    }
}
