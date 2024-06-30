package Arrays;

public class linerSearch {
    
public static int linearSearch(int arr[], int x) {
    
    for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == x){
                return i;
        }
    }
    return -1;
}
public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9};
    int number = 5;
    int ans = linearSearch(arr, number);
    System.out.println(ans);
}
}
