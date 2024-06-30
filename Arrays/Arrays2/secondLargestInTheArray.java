/*Problem statement
You have been given a random integer array/list(ARR) of size N. You are required to find and return the second largest element present in the array/list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^2
1<=arr[i]<=10^3

Time Limit: 1 sec
Sample Input 1:
5
4 3 10 9 2
Sample Output 1:
9
Sample Input 2:
7
13 6 31 14 29 44 3
Sample Output 2:
31 */
package Arrays.Arrays2;

public class secondLargestInTheArray {
    public static int secondLargest(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 10, 9, 2};
        System.out.println(secondLargest(arr));
    }
}
