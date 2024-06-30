package HashMap.Assignments;
import java.util.*;
/*Problem statement
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.

Note: Take absolute difference between the elements of the array.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2
Explanation
(5,2) and (1,4) are the possible combinations as their absolute difference is 3.
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6 */
public class pairWithDifferenceK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int pairCount = 0;
		for(int item:arr) 
		{
			int p1 = item + k;
			boolean flag = false;
			if(item == p1) 
			{
				flag = true; //this case is there for k=0
			}
			if(map.containsKey(p1)) 
			{
			  pairCount += map.get(p1);	
			}
			int p2 = item - k;
			if(map.containsKey(p2) && !flag)
			{
				pairCount += map.get(p2);
			}
			if(map.containsKey(item)) {
				map.put(item, map.get(item)+1);
			}else {
				map.put(item, 1);
			}
		}
		return pairCount;
	}

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {5, 1, 2, 4};
        int k1 = 3;
        System.out.println("Test Case 1: " + getPairsWithDifferenceK(arr1, k1)); // Expected output: 2

        // Test case 2
        int[] arr2 = {4, 4, 4, 4};
        int k2 = 0;
        System.out.println("Test Case 2: " + getPairsWithDifferenceK(arr2, k2)); // Expected output: 6

        // Additional test cases
        // Test case 3
        int[] arr3 = {1, 5, 3, 4, 2};
        int k3 = 2;
        System.out.println("Test Case 3: " + getPairsWithDifferenceK(arr3, k3)); // Expected output: 3

        // Test case 4
        int[] arr4 = {8, 12, 16, 4, 0, 20};
        int k4 = 4;
        System.out.println("Test Case 4: " + getPairsWithDifferenceK(arr4, k4)); // Expected output: 5
    }
}
