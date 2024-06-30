package Arrays.Arrays2;

public class selectionSort {
    public static void selectionSort1(int[] arr) {
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int swapIndex = i;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    swapIndex = j;
                }
            }
            int temp = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr [] = {1,3,6,2,1,23,34,45};
        selectionSort1(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
