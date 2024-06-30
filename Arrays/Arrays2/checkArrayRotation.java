package Arrays.Arrays2;
/*Problem statement
You have been given an integer array/list(ARR) of size N. It has been sorted(in increasing order) and then rotated by some number 'K' (K is greater than 0) in the right hand direction.

Your task is to write a function that returns the value of 'K', that means, the index from which the array/list has been rotated.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
2 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1:
1
6
5 6 1 2 3 4
Sample Output 1:
2
Sample Input 2:
2
5
3 6 8 9 10
4
10 20 30 1
Sample Output 2:
0
3 */
public class checkArrayRotation {
    public static int arrayRotateCheck(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            // Case 1: If the array is already sorted, return 0
            if (arr[low] <= arr[high]) {
                return low;
            }
            
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;
            
            // Case 2: Check if mid is the minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }
            
            // Case 3: Decide to go left or right
            if (arr[mid] <= arr[high]) {
                high = mid - 1; // Search left
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1; // Search right
            }
        }
        
        return -1; // In case of error or invalid input
    }
    public static void main(String[] args) {
        int[] arr1 = { 5, 6, 1, 2, 3, 4 };
        System.out.println("Rotation index for arr1: " + arrayRotateCheck(arr1)); 
    }
}
