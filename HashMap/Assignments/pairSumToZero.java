package HashMap.Assignments;

import HashMap.HashMap;

/*Problem statement
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.



Note:
Array A can contain duplicate elements as well.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
Explanation
(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2. */
public class pairSumToZero {
    public static int PairSum(int[] input, int size) {
        if (size == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : input) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int countPairs = 0;
        for (Integer i : map.keySet()) {
            if (map.containsKey(-i) && i != 0) {
                countPairs += map.get(i) * map.get(-i);
            }
        }

        countPairs /= 2;

        if (map.containsKey(0)) {
            int val = map.get(0);
            countPairs += (val * (val - 1)) / 2;
        }

        return countPairs;
    }
   public static void main(String[] args) {
    int[] testCase1 = {2, 1, -2, 2, 3};
    int size1 = testCase1.length;
    System.out.println("Test Case 1: " + PairSum(testCase1, size1)); // Expected output: 2

    // Additional test cases
    // Test case 2
    int[] testCase2 = {4, -4, 2, -2, 3, 3, -3, -3, -3};
    int size2 = testCase2.length;
    System.out.println("Test Case 2: " + PairSum(testCase2, size2)); // Expected output: 9
  
   }
}
