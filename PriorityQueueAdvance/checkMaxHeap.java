package PriorityQueueAdvance;

/*Problem statement
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true */
public class checkMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		       return checkMaxHeapHelper(arr,0);
	}

	 private static boolean checkMaxHeapHelper(int[] arr, int startIndex)
    {
        //Base case - if the current parent node index (startIndex) is greater than array size,
        //then, we have successfully reached the end of the heap nd at each level the max heap property is satisfied
        //Hence, we return true
        if(startIndex==arr.length)
            return true;
        
        //Calculate the current indices of the parent and its children
        int parentIndex=startIndex;
        int leftChildIndex=2*parentIndex+1,rightChildIndex=2*parentIndex+2;
        
        //Assume that the max heap property is satisfied for both children of the current parent
        boolean leftAns=true,rightAns=true;
        
        //If index of left child > array size, then the left child does not exist. Hence, we retain the leftAns=true
        //If the condition is satisfied, we check if the parent<left child. If it is true, we return false as 
        //max heap property is violated. Else, we continue with the checks by making the left child the new parent
        if(leftChildIndex<arr.length)
        {
            if(arr[parentIndex]<arr[leftChildIndex])
                return false;
            else
                leftAns=checkMaxHeapHelper(arr,leftChildIndex);
        }
        
        //The if-condition for the right child follows same logic as of the left child
        if(rightChildIndex<arr.length)
        {
            if(arr[parentIndex]<arr[rightChildIndex])
                return false;
            else
                rightAns=checkMaxHeapHelper(arr,rightChildIndex);
        }
        
        //If current parent satisfies the max heap property, then the results for its left and/or right child are 
        //used to determine if the property is maintained.
        return (leftAns && rightAns);
            
    }
    public static void main(String[] args) {
        int[] arr1 = {42, 20, 18, 6, 14, 11, 9, 4};
        boolean result1 = checkMaxHeap.checkMaxHeap(arr1);
        System.out.println(result1); // Expected output: true
        
        int[] arr2 = {30, 20, 10, 8, 15};
        boolean result2 = checkMaxHeap.checkMaxHeap(arr2);
        System.out.println(result2); // Expected output: false
        
        int[] arr3 = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        boolean result3 = checkMaxHeap.checkMaxHeap(arr3);
        System.out.println(result3); // Expected output: true
    }
}
