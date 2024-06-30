package HashMap.Assignments;
import java.util.HashMap;

import ArrayList.ArrayList;
/*Problem statement
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in ascending order.


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= M <= 10^4

Time Limit: 1 sec 
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7 
2
10 10
1
10
Sample Output 1 :
2 3 4
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 2 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. The first '2' of first array matches with the first '2' of the second array. Similarly, the second '2' of the first array matches with the second '2' if the second array. */
public class arrayIntersection {
    
	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
			
	   	HashMap<Integer,Integer>map= new HashMap<>();
		
		for(int i=0;i<arr1.length;i++) {
			if(map.containsKey(arr1[i])) {
				int val= map.get(arr1[i]);
				map.put(arr1[i], val+1);
			}
			else {
				map.put(arr1[i],1);
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			if(map.containsKey(arr2[i])) {
				int freq=map.get(arr2[i]);
				if(freq>0) {
					System.out.print(arr2[i]+" ");
					map.put(arr2[i],freq-1);
				}
			}
		}
}


public static void main(String[] args) {
    // Test case 1
    int[] arr1_1 = {2, 6, 8, 5, 4, 3};
    int[] arr1_2 = {2, 3, 4, 7};
    intersection(arr1_1, arr1_2); // Expected output: 2 3 4

    // Test case 2
    int[] arr2_1 = {10, 10};
    int[] arr2_2 = {10};
    intersection(arr2_1, arr2_2); // Expected output: 10

    // Test case 3
    int[] arr3_1 = {2, 6, 1, 2};
    int[] arr3_2 = {1, 2, 3, 4, 2};
    intersection(arr3_1, arr3_2); // Expected output: 1 2 2
}
}
