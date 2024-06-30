package RecurssionHard;
/*Problem statement
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.

Return empty string for numbers 0 and 1.

Note :
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= n <= 10^6

Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf */
public class returnKeyPadString {
    private static String helper(int newN){
        if(newN==2)
            return "abc";
        if(newN==3)
            return "def";
        if(newN==4)
            return "ghi";
        if(newN==5)
            return "jkl";
        if(newN==6)
            return "mno";
        if(newN==7)
            return "pqrs";
        if(newN==8)
            return "tuv";
        if(newN==9)
            return "wxyz";
        else
            return "";


    }

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
		if(n==0) {
			String []output= new String [1];
			output[0]="";
			return output;
		}
		String smallop[]=keypad(n/10);
		int lastDigit=n%10;
		String lastDigitOptions=helper(lastDigit);
		
		String output[]=new String[smallop.length* lastDigitOptions.length()];
		int k=0;
		for(int i=0;i<smallop.length;i++) {
			for(int j=0;j<lastDigitOptions.length();j++) {
				output[k]=smallop[i] +lastDigitOptions.charAt(j);
				k++;
			}
		}
		return output;

	}
    public static void main(String[] args) {
        // Test case 1
        int input1 = 23;
        System.out.println("Input: " + input1);
        String[] result1 = returnKeyPadString.keypad(input1);
        System.out.println("Output:");
        printArray(result1);

        // Test case 2
        int input2 = 789;
        System.out.println("\nInput: " + input2);
        String[] result2 = returnKeyPadString.keypad(input2);
        System.out.println("Output:");
        printArray(result2);
    }

    // Helper method to print string array
    private static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
