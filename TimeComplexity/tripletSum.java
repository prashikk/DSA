package TimeComplexity;
import java.util.*;
/*Problem statement
You have been given a random integer array/list(ARR) and a number X. Find and return the triplet(s) in the array/list which sum to X.

Note :
Given array/list can contain duplicate elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= X <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7 
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7 
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5


 Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to 19 for the first query, we print 0.

For the second query, we have 5 triplets in total that sum up to 10. They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11) */
public class tripletSum {
    private static int pairSum(int[] arr, int startIndex, int endIndex, int num ){
    
        int numPair = 0;
        while(startIndex < endIndex){
            if(arr[startIndex] + arr[endIndex] < num){
                startIndex++;
            }
            else if(arr[startIndex] + arr[endIndex] > num){
                endIndex--;
            }
            else
            {
                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];
                
                if(elementAtStart == elementAtEnd){
                    int totalElementsFromStartToEnd = (endIndex - startIndex) + 1;
                    numPair += (totalElementsFromStartToEnd * (totalElementsFromStartToEnd -1) /2);
                    
                    return numPair;
                }
                int tempStartIndex = startIndex + 1;
                int tempEndIndex = endIndex - 1;
                
                while(tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart){
                    tempStartIndex+=1;
                }
                while(tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd){
                    tempEndIndex-=1;
                }
                int totalElementsFromStart = (tempStartIndex - startIndex);
                int totalElementsFromEnd = (endIndex - tempEndIndex);
                
                numPair += (totalElementsFromStart * totalElementsFromEnd);
                
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }
    
        public static int tripletSum(int[] arr, int num) {
            //Your code goes here
             Arrays.sort(arr);
        int n = arr.length;
        
        int Numtripletsum = 0;
        for(int i=0;i<n;i++)
        {
            int pairSumFor = num - arr[i];
            int numPairs = pairSum(arr, (i+1), (n-1), pairSumFor);
            Numtripletsum+=numPairs;
        }
        return Numtripletsum;
        }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int num1 = 12;
        System.out.println(tripletSum(arr1, num1)); // Output: 5
        
        int[] arr2 = {1, 2, 3};
        int num2 = 6;
        System.out.println(tripletSum(arr2, num2)); // Output: 1
    }
}
