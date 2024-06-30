package RecursionAdvance;
/*Problem statement
Given a string, compute recursively a new string where all 'x' chars have been removed.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S. 
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3: */
public class removeX {
    public static String remove(String str,char a) {
		
		if(str.length()==0) {
			return str;
		}
		String s= remove(str.substring(1),a);
		if(str.charAt(0)== a) {
			return s;
			
		}
		else {
			return str.charAt(0)+s;
		}
		
		
	}

	public static String removeX(String input){
        return remove(input,'x');
	}
    public static void main(String[] args) {
        System.out.println(removeX("xaxb"));
    }
}
