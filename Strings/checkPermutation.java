package Strings;
/*Problem statement
For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.

Permutations of each other
Two strings are said to be a permutation of each other when either of the string's characters can be rearranged so that it becomes identical to the other one.

Example: 
str1= "sinrtg" 
str2 = "string"

The character of the first string(str1) can be rearranged to form str2 and hence we can say that the given strings are a permutation of each other.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abcde
baedc
Sample Output 1:
true
Sample Input 2:
abc
cbd
Sample Output 2:
false */
public class checkPermutation {
    public static boolean isPermutation(String str1, String str2) {
		//Your code goes here
		int frequencyArr[]=new int[256];
  int count=0;
for(int i=0;i<str1.length();i++){
int cha=str1.charAt(i);
    frequencyArr[cha]=frequencyArr[cha]+1;}
    for(int i=0;i<str2.length();i++)
    {
        int ch=str2.charAt(i);
        frequencyArr[ch]=frequencyArr[ch]-1;
 }
    for(int i=0;i<256;i++)
    {
        if(frequencyArr[i]==0)
            count++;
    }
    if(count==256)
        return true;
    else
        return false;

	
	}
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cba";
        System.out.println(isPermutation(str1, str2)); 
    }
}
