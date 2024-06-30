package Recursion;
/*Problem statement
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 10
8
Sample Output 1 :
true
Sample Input 2 :
3
9 8 10
2
Sample Output 2 :
false */
public class checkNumberRecursively {
    public static boolean checkNumber(int input[], int x) {
        return check(input, 0, x);
    }
    
    private static boolean check(int arr[], int startIndex, int x) {
        // Base case: If startIndex is out of bounds, return false
        if (startIndex >= arr.length) {
            return false;
        }
        
        // Check if current element equals x
        if (arr[startIndex] == x) {
            return true;
        }
        
        // Recursive case: Check in the rest of the array
        return check(arr, startIndex + 1, x);
    }
    public static void main(String[] args) {
        int[] arr1 = {9, 8, 10};
        int[] arr2 = {9, 8, 10};
        
        System.out.println(checkNumber(arr1, 8)); // Output: true
        System.out.println(checkNumber(arr2, 2)); // Output: false
    }
}
