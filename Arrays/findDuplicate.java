package Arrays;

public class findDuplicate {
    private static int duplicateNumber(int arr[]) {
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] == arr[i]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr [] = {10,7,2,5,4,7,1,3,6};
        System.out.println(duplicateNumber(arr));
    }
}
