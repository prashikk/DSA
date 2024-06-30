package Arrays;

public class swapAlternate {

    private static void swapAlternate(int arr[]) {
        for(int i = 0 ; i< arr.length ; i++){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            i++;
        }
    }
    public static void main(String[] args) {
        int arr[] = {9,3,6,12,4,32};
        swapAlternate(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+",");
        }
    }
}
