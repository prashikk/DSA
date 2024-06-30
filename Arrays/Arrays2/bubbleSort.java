package Arrays.Arrays2;

public class bubbleSort {
    public static void bubbleSort1(int[] arr) {
        for(int i = 0 ; i < arr.length - 1; i++){
            for(int j = 0 ; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {12,23,11,23,1,67,34,43};
        bubbleSort1(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
