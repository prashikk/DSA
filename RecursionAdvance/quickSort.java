package RecursionAdvance;
/*Problem statement
Given the 'start' and the 'end'' positions of the array 'input'. Your task is to sort the elements between 'start' and 'end' using quick sort.



Note :
Make changes in the input array itself.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
1 2 3 5 7
Sample Output 2 :
1 2 3 5 7 
Constraints :
1 <= N <= 10^3
0 <= input[i] <= 10^9 */
public class quickSort {

    
		public static int partion(int arr[],int si,int ei) {
            int piv=arr[si];
            int smallcount=0;
            for(int i=si+1;i<=ei;i++) {
                if(arr[i]<piv) {
                    smallcount++;
                }
            }
            int temp=arr[si+smallcount];
            arr[si+smallcount]=piv;
            arr[si]=temp;
            
            int i=si;
            int j=ei;
            while(i<j) {
                if(arr[i]<piv) {
                    i++;
                }
                else if(arr[j]>=piv) {
                    j--;
                }
                else {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                    j--;
                }
            }
            return si+smallcount;
            
        }
    
        public static void quicksort(int arr[],int si,int ei) {
            
            if(si>=ei) {
                return;
            }
            int pivid=partion(arr,si,ei);
            quicksort(arr,si,pivid-1);
            quicksort(arr,pivid+1,ei);
            
        }
        
        public static void quickSort(int[] input) {
        quicksort(input,0,input.length-1);
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
        
        quickSort(input);
        
        System.out.println("Sorted array:");
        printArray(input);
    }
}
