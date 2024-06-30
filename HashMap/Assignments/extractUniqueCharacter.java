package HashMap.Assignments;
import java.util.*;
/*Problem statement
Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde */
public class extractUniqueCharacter {
    public static String uniqueChar(String str){
			HashMap<Character ,Integer>map= new HashMap<>();
		
		String s="";
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(!map.containsKey(ch)) {
				s=s+ch;
				map.put(ch,1);
				}
		}
		return s;

	}

    public static void main(String[] args) {
        // Test case 1
        String input1 = "ababacd";
        System.out.println("Test Case 1: " + uniqueChar(input1)); // Expected output: abcd

        // Test case 2
        String input2 = "abcde";
        System.out.println("Test Case 2: " + uniqueChar(input2)); // Expected output: abcde

        // Additional test cases
        // Test case 3
        String input3 = "aaaaaa";
        System.out.println("Test Case 3: " + uniqueChar(input3)); // Expected output: a
        
        // Test case 4
        String input4 = "";
        System.out.println("Test Case 4: " + uniqueChar(input4)); // Expected output: 

        // Test case 5
        String input5 = "abcdefg";
        System.out.println("Test Case 5: " + uniqueChar(input5)); // Expected output: abcdefg
    }
}
