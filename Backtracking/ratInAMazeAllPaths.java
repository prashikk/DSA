package Backtracking;
/*Problem statement
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).

Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format. */
public class ratInAMazeAllPaths {
    static void ratInAMaze(int maze[][], int n) {
		/* 
			* Your class should be named Solution.
			* Write your code here
		 */

		int path[][]=new int[maze.length][maze.length];
		printAllPaths(maze,0,0,path,n);

	}

	  public static void printAllPaths(int maze[][],int i,int j, int path[][], int n)
	{
		
		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1)
		{
			return;
		}
		path[i][j]=1;
		
		if(i==n-1 && j==n-1)
		{
			for(int r = 0;r<n;r++)
			{
				for(int c = 0;c<n;c++)
				{
					System.out.print(path[r][c]+" ");
				}
				
			}
			
			path[i][j]=0;
            System.out.println();
            return;
		}
		
		//top
		printAllPaths(maze,i-1,j,path,n);
		//down
		printAllPaths(maze, i+1, j, path,n);
        //left
		printAllPaths(maze, i, j-1, path,n);
		//right
		printAllPaths(maze,i,j+1,path,n);
		
		path[i][j]=0;
		
		
		
	}
    public static void main(String[] args) {
        // Test Case 1
        int maze1[][] = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Test Case 1:");
        System.out.println("Paths in maze 1:");
        ratInAMazeAllPaths.ratInAMaze(maze1, 3);
        System.out.println();

        // Test Case 2
        int maze2[][] = {
            {1, 0, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println("Test Case 2:");
        System.out.println("Paths in maze 2:");
        ratInAMazeAllPaths.ratInAMaze(maze2, 3);
    }
}
