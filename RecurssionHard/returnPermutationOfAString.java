package RecurssionHard;
/*Problem statement
Given a string, find and return all the possible permutations of the input string.

Note :
The order of permutations are not important.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba */
public class returnPermutationOfAString {
    public static String[] permutationOfString(String input){
		// Write your code here
		 if(input.length() == 0){
            String y[] = {""};
            return y;
        }
        
        String [] ans = permutationOfString(input.substring(1));
      //  char ch = input.charAt(0);
		String output[] = new String[ans.length*input.length()];
        
        int k=0;
        for(int i=0;i<ans.length;i++){
            
            for(int j=0;j<=ans[i].length();j++){
                output[k++] = ans[i].substring(0,j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        
        return output;
		
	}
    public static void main(String[] args) {
        // Test case
        String input = "abc";
        System.out.println("Input String: " + input);
        System.out.println("Permutations of the input string:");
        String[] permutations = returnPermutationOfAString.permutationOfString(input);
        printPermutations(permutations);
    }

    public static void printPermutations(String[] permutations) {
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
