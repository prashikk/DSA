package RecursionAdvance;

import java.util.Scanner;

/*Problem statement
Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :

1) Only one disk can be moved at a time.
2) A disk can be moved only if it is on the top of a rod.
3) No disk can be placed on the top of a smaller disk.
Print the steps required to move n disks from source rod to destination rod.

Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 20
Sample Input 1 :
2
Sample Output 1 :
a b
a c
b c
Sample Input 2 :
3
Sample Output 2 :
a c
a b
c b
a c
b a
b c
a c */
public class towerOfHanoi {

    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		// Write your code here
		  if(disks==0)
            return;
        else if(disks==1)
        { System.out.println(source+" "+destination);
         return;
        }
       
        towerOfHanoi(disks-1,source,destination,auxiliary);
        System.out.println(source+" "+destination);
        towerOfHanoi(disks-1,auxiliary,source,destination);


	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int disks = scanner.nextInt();
        scanner.close();

        // Perform Tower of Hanoi
        towerOfHanoi(disks, 'A', 'B', 'C');
    }
}
