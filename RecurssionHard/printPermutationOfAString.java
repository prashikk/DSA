package RecurssionHard;
/*Problem statement
Given a string, find and print all the possible permutations of the input string.

Note :
The order of permutations are not important. Just print them in different lines.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba */
public class printPermutationOfAString {
    public static void permutations(String input){
		// Write your code here
		 print(input,"");

	}
	  private static void print(String input,String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        
        for(int i=0;i<input.length();i++){
            String str = input.substring(0,i) + input.substring(i+1,input.length());    
            print(str , output + input.charAt(i));
        }
        
        // input = input.substring(1);
        // print(input,output);
        
        
    }
    public static void main(String[] args) {
        // Test Case 1
        String input1 = "abc";
        System.out.println("Permutations of '" + input1 + "':");
        printPermutationOfAString.permutations(input1);
        System.out.println();

        // Test Case 2
        String input2 = "xyz";
        System.out.println("Permutations of '" + input2 + "':");
        printPermutationOfAString.permutations(input2);
    }
}
