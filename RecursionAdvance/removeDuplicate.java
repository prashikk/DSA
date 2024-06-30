package RecursionAdvance;
/*Problem statement
Given a string S, remove consecutive duplicates from it recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz */
public class removeDuplicate {
    public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
	     if(s.length()<=1){
            return s;
		 }
        String smallans=removeConsecutiveDuplicates(s.substring(1));
        if(smallans.charAt(0)==s.charAt(0)){
            return smallans;
		}
        else{
            return s.charAt(0)+smallans;

    }

	}
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aabccba"));
    }
}
