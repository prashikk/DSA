package Arrays.Arrays2;

public class pushZeroToEnd {

    public static void pushZerosAtEnd(int[] arr) {
        int zeroCount = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[zeroCount];
                arr[zeroCount] = temp;
                zeroCount++;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        pushZerosAtEnd(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
