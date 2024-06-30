package Arrays.Arrays2;

public class binarySearch {

    public static int binarySearch1(int[] arr, int x) {
        int startIndex = 0;
        int endIndex = arr.length -1;
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex)/2;
            if(arr[midIndex] > x){
                endIndex = midIndex;
            }
            else if(arr[midIndex] < x){
                startIndex = midIndex ;
            }
            else{
                return midIndex;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16,};
        System.out.println(binarySearch1(arr, 12));
    }
}
