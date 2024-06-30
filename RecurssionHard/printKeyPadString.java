package RecurssionHard;
/*Problem statement
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.





Note :
The order of strings are not important. Just print different strings in new lines.
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
public class printKeyPadString {
    public static void printKeypad(int input){
		// Write your code here
		printkeypad(input,"");
	}

		
	public static void printkeypad(int input,String stringsofar) {
		if(input==0) {
			System.out.println(stringsofar);
			return;
		}
		int lastdigit=input%10;
		int smallip=input/10;
		String optionslastDigit=getOptions(lastdigit);
		for(int i=0;i<optionslastDigit.length();i++) {
			printkeypad(smallip,  optionslastDigit.charAt(i)+ stringsofar);
		}
	}
	
	   private static String getOptions(int newN){
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

        public static void main(String[] args) {
            // Test case 1
            int input1 = 23;
            System.out.println("Input: " + input1);
            System.out.println("Output:");
            printKeyPadString.printKeypad(input1);
    
            // Test case 2
            int input2 = 789;
            System.out.println("\nInput: " + input2);
            System.out.println("Output:");
            printKeyPadString.printKeypad(input2);
        }
}
