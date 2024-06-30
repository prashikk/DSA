package Recursion;
/*Problem statement
Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.

First index means, the index of first occurrence of x in the input array.

Do this recursively. Indexing in the array starts from 0.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
1 */
public class firstIndex {
    public static int find(int arr[],int x,int si) {
		
		if(si==arr.length) {
			return -1;
		}
		if(arr[si]==x) {
			return si;
		}
		
		int result=find(arr,x,si+1);
		return result;
		
	}

	public static int firstIndex(int input[], int x) {
		return find(input,x,0);
		
	}
    public static void main(String[] args) {
        int[] arr1 = {9, 8, 10, 8};
        int[] arr2 = {9, 8, 10, 8};
        
        System.out.println(firstIndex(arr1, 8)); // Output: 1
        System.out.println(firstIndex(arr2, 2)); // Output: -1
    }
}
