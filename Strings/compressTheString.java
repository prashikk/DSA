package Strings;

public class compressTheString {
    public static String getCompressedString(String str) {
		// Write your code here.
		int i,c = 1,j = 0;
   String result = "";
   for(i = 0;i < str.length() - 1;i++) {
	   if(str.charAt(i+1) == str.charAt(i)) {
		   c++;	   
	   }
	   else {
		   if(c != 1)
		   result = result + str.charAt(i) + c;
		   else
		   result = result + str.charAt(i);
           c = 1;
	   }
   }
   if(c != 1)
   result = result + str.charAt(i) + c;
   else
   result = result + str.charAt(i);   
   return result;
	}
    public static void main(String[] args) {
        System.out.println(getCompressedString("aaabbbccc")); // Output: "a3b3c3"
        System.out.println(getCompressedString("abcd")); // Output: "abcd"
        System.out.println(getCompressedString("aabbbccdd")); // Output: "a2b3c2d2"
    }
}
