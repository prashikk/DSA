package RecurssionAssignment;
/*Problem statement
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 30
Sample Input 1 :
4
Sample Output 1 :
7
Sample Input 2 :
5
Sample Output 2 :
13 */
public class staircase {

    public static int staircase(int n){
           if(n<0)
                return 0;
            if(n==0)
                return 1;
            int op1=staircase(n-1);
            int op2=staircase(n-2);
            int op3=staircase(n-3);
            return op1+op2+op3;
    
        }
    public static void main(String[] args) {
        System.out.println(staircase(5));
    }
}
