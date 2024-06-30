package Arrays;

public class sortNum {
    public static void sort012(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high){
            switch(arr[mid]){
                case 0:
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
                break;

                case 1:
                mid++;
                break;

                case 2:
                int temp1 = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp1;
                high--;
                break;

            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,2,0,1};
        sort012(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
