package Arrays;

public class pairSum {
    private static int pairSum(int arr[], int x) {
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] + arr[j] == x){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr [] = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        System.out.println(pairSum(arr, 7));
    }
}
