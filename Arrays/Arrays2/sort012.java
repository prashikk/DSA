package Arrays.Arrays2;

import java.util.Arrays;

/*Problem statement
You are given an integer array/list(ARR) of size N. It contains only 0s, 1s and 2s. Write a solution to sort this array/list in a 'single scan'.

'Single Scan' refers to iterating over the array/list just once or to put it in other words, you will be visiting each element in the array/list just once.

Note:
1. You need to change in the given array/list itself. Hence, no need to return or print anything. 
2. You are not allowed to sort the list/array directly.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1:
1
7
0 1 2 0 2 0 1
Sample Output 1:
0 0 0 1 1 2 2 
Explanation:  The array contains three 0s, two 1s, and two 2s. After sorting the array in a single scan, the 0s should come first, then the 1s, and finally the 2s. So the output is 0 0 0 1 1 2 2.
Sample Input 2:
2
5
2 2 0 1 1
7
0 1 2 0 1 2 0
Sample Output 2:
0 1 1 2 2 
Explanation: The array contains one 0, two 1s, and two 2s. After sorting, the 0 comes first, then the 1s, and finally the 2s. So the output is 0 1 1 2 2.
0 0 0 1 1 2 2
Explanation: The array contains three 0s, two 1s, and two 2s. After sorting, the 0s come first, then the 1s, and finally the 2s. So the output is 0 0 0 1 1 2 2.
void sort012(int *arr, int n)
{
    //Write your code here
}
 */
public class sort012 {

    public static void sort(int[] arr){
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;
    int temp;
    
    while (mid <= high) {
        switch (arr[mid]) {
            case 0:
                // Swap arr[low] and arr[mid], increment both low and mid
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
                break;
            case 1:
                // No swap needed, just move mid forward
                mid++;
                break;
            case 2:
                // Swap arr[mid] and arr[high], decrement high
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
                // Do not increment mid here because arr[mid] needs to be re-evaluated
                break;
        }
    }
}
    
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 0, 2, 0, 1};
        sort(arr1);
        
        System.out.println("Sorted arr1: " + Arrays.toString(arr1));
    }
}
