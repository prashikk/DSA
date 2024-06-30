package Arrays;

public class sortZeroAndOne {
    public static void sortZeroesAndOne(int[] arr) {
        
		  int indexOf0 = 0;
          int IndexOf2 = arr.length -1;
          int i = 1;
          int temp = 0;
          while(i < arr.length )  {
              if(arr[i] == 0 && i > indexOf0) {
                  temp = arr[i];
                  arr[i] = arr[indexOf0];
                  arr[indexOf0] = temp;
                  indexOf0++;
              } else if(arr[i] == 2 && i < IndexOf2) {
                  temp = arr[i];
                  arr[i] = arr[IndexOf2];
                  arr[IndexOf2] = temp;
                  IndexOf2--;
              } else
                  i++;
          }
        
    }
    public static void main(String[] args) {
        int arr [] = {0,1,1,0,0,0,1};
        sortZeroesAndOne(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i] + " ");
        }
    }
}
