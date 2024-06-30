package Pattern;

public class starPattern {

    //op
    // *
    // **
    // ***
    public static void printRightAngle(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //op
    // ****
    // ***
    // **
    // *
    public static void printInvertedRightAngle(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
//op -
//         *
//        **
//       ***
//      ****
//     *****
//    ******
//   *******
//  ********
    public static void rightAngleLeftSide(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n - i; j++){
                System.out.print(" ");
            }
            for(int k = 0 ; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //op - 
    // *********
    // ********
    // *******
    // ******
    // *****
    // ****
    // ***
    // **
    // *
    public static void rightAngleLeftSideInverted(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n - i; j++){
                System.out.print("*");
            }
          
            System.out.println();
        }
    }
//op-
//      *
//     ***
//    *****
//   *******
    public static void prymid(int rows ){
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String []args){
       printRightAngle(4);
       printInvertedRightAngle(4);
       rightAngleLeftSide(4);
       rightAngleLeftSideInverted(4);
       prymid(4);
    }
}
