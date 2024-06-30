package Recursion;
/*Problem statement
Given an array of length N, you need to find and return the sum of all elements of the array.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7     */
public class sumOfArray {
    public static int sum(int input[]) {
        return sumRecursive(input, 0);
    }
    
    private static int sumRecursive(int[] arr, int index) {
        // Base case: If index exceeds array length, return 0
        if (index >= arr.length) {
            return 0;
        }
        
        // Recursive case: Return current element + sum of rest of the array
        return arr[index] + sumRecursive(arr, index + 1);
    }
    public static void main(String[] args) {
        int[] arr1 = {9, 8, 9};
        int[] arr2 = {4, 2, 1};
        
        System.out.println(sum(arr1)); // Output: 26
        System.out.println(sum(arr2)); // Output: 7
    }
}
