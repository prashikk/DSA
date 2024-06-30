package PriorityQueueAdvance;
/*Problem statement
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.

Note: Space complexity should be O(1).

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2 */

import java.util.Arrays;

public class implaceHeapSort {
    public static void inplaceHeapSort(int arr[]) {
        for(int i=0;i<arr.length;i++)
        {
            insertMin(arr,i);
          
        }
       
        for(int i=0;i<arr.length;i++)
        {
            arr[arr.length-1-i]=removeMin(arr,arr.length-i);
        }
		
	}
	    public static int removeMin(int arr[],int heapsize){
        int temp=arr[0];
        arr[0]=arr[heapsize-1];
        heapsize--;
        int lchild=1;    
        int rchild=2;
        int parentindex=0;
        int minindex=parentindex;
        while(lchild<heapsize){
            
            if(arr[lchild]<arr[minindex])
                minindex=lchild;
            if(rchild<heapsize && arr[rchild]<arr[minindex])
                minindex=rchild;
            if(parentindex==minindex)
                break;
            else{
                int temp1=arr[parentindex];
                arr[parentindex]=arr[minindex];
                arr[minindex]=temp1;
                parentindex=minindex;
                lchild=2*parentindex+1;
                rchild=2*parentindex+2;
                }
        }



        return temp;     
    }
	  public static void insertMin(int arr[],int i){
        int childindex=i;
        int parentindex=(i-1)/2;
        while(childindex>0){
            if(arr[parentindex]>arr[childindex])
            {
                int temp=arr[parentindex];
                arr[parentindex]=arr[childindex];
                arr[childindex]=temp;
                childindex=parentindex;
                parentindex=(childindex-1)/2;

            }
            else
                return;
		}
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 5, 4, 3};
        System.out.println("Original Array: " + Arrays.toString(arr1));
        inplaceHeapSort(arr1);
        System.out.println("Sorted Array (Decreasing Order): " + Arrays.toString(arr1));

        int[] arr2 = {10, 3, 7, 1, 9};
        System.out.println("\nOriginal Array: " + Arrays.toString(arr2));
        inplaceHeapSort(arr2);
        System.out.println("Sorted Array (Decreasing Order): " + Arrays.toString(arr2));
    }
}
