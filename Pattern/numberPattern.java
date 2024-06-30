package Pattern;
class numberPattern{

// Pattern
// 123
// 123
// 123
    public static void printPattern1(int n){
        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < n ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }


// Pattern
// 111
// 222
// 333
    public static void printPattern2(int n){
        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < n ; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        int n = 4;
        printPattern1(n);
        printPattern2(n);

    }
}