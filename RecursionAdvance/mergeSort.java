package RecursionAdvance;
/*Problem statement
You are given the starting 'l' and the ending 'r' positions of the array 'ARR'.



You must sort the elements between 'l' and 'r'.



Note:
Change in the input array itself. So no need to return or print anything.
Example:
Input: ‘N’ = 7,
'ARR' = [2, 13, 4, 1, 3, 6, 28]

Output: [1 2 3 4 6 13 28]

Explanation: After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28
Explanation of Sample Output 1:
After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
Sample Input 2:
5
9 3 6 2 0
Sample Output 2:
0 2 3 6 9
Explanation of Sample Output 2:
After applying 'merge sort' on the input array, the output is [0 2 3 6 9].
Constraints :
1 <= N <= 10^3
0 <= ARR[i] <= 10^9 */
public class mergeSort {
    public static void merge(int a[],int b[],int[] d ) {
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]) {
				d[k]=a[i];
				i++;
				k++;
			}
			else {
				d[k]=b[j];
				j++;
				k++;
				
			}
		}
		if(i<a.length) {
			while(i<a.length) {
				d[k]=a[i];
				i++;
				k++;
			}
			
		}
		if(j<b.length) {
			while(j<b.length) {
				d[k]=b[j];
				j++;
				k++;
			}
		}
		
	}

	public static void mergeSort(int[] input){
		// Write your code here
				if(input.length<=1) {
			return;
		}
		
		int []a= new int[input.length/2];
		int []b=new int[input.length - a.length];
		
		for(int i=0;i<input.length/2;i++) {
			a[i]=input[i];
		}
		for(int j=input.length/2;j<input.length;j++) {
			b[j-input.length/2]=input[j];
		}
		
		mergeSort(a);
		mergeSort(b);
		merge(a,b,input);
		
	}
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Original array:");
        printArray(input);
        
        mergeSort(input);
        
        System.out.println("Sorted array:");
        printArray(input);
    }
}
