package Recursion;
/*Problem statement
You are given a number 'n'.



Return number of digits in ‘n’.



Example:
Input: 'n' = 123

Output: 3

Explanation:
The 3 digits in ‘123’ are 1, 2 and 3. 


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
121


Sample Output 1:
3


Explanation of sample output 1:
There are 3 digits in 121 are 1,2 and 1.

Sample Input 2:
38


Sample Output 2:
2


Expected time complexity :
The expected time complexity is O(log n).


Constraints:
1 <= ‘n’ <= 10^9 */
public class numberOfDigit {
    public static int count(int n){
        if(n == 0) {
            return 0;
        } else {
            int a = count(n / 10); // Recursive call to count digits of n/10
            int ans = a + 1;       // Increment the count of digits obtained from recursive call
            return ans;
        }
    }
    public static void main(String[] args) {
        int num1 = 123;
        int num2 = 121;
        int num3 = 38;

        System.out.println(count(num1)); // Output: 3
        System.out.println(count(num2)); // Output: 3
        System.out.println(count(num3)); // Output: 2
    }
}
