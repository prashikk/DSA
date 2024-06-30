package Arrays.Arrays2;

public class mergeTwoSortedArray {
    public static int[] merge(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArray = new int[n + m];
        
        int i = 0, j = 0, k = 0;

        // Traverse both arrays and merge them
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1[], if any
        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2[], if any
        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int mergeArr[] = merge(arr1, arr2);
        for(int i = 0 ; i < mergeArr.length ; i++){
            System.out.print(mergeArr[i] + " ");
        }
    }
}
