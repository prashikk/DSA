package Backtracking;

public class ratInAMaze {
    public static boolean ratInAMaze(int maze[][]){

		/*Your class should be named Solution. 
		*Don't write main().
	 	*Don't take input, it is passed as function argument.
	 	*Don't print output.
	 	*Taking input and printing output is handled automatically.
		*/ 
int n = maze.length;
        int path[][] = new int[n][n];
         return solveMaze(maze, 0, 0, path);
	}

	   public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
//        Checking if the current cell which we are going to traverse is a valid cell or not?
        if (i < 0 || i >= maze.length || j < 0 || j >= maze.length || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }
//        Including the current cell to be in path[i][j]
        path[i][j] = 1;
//        Checking if the current cell is destination cell or not
        if (i == maze.length - 1 && j == maze.length - 1) {
//            printing the path before returning
            return true;
        }
//        Explore further the maze in all direction
//        Top Direction
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }
//        Right Direction
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }
//        Bottom Direction
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }
//        Left Direction
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // Test Case 1
        int maze1[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        System.out.println("Test Case 1:");
        System.out.println("Is there a path in maze 1? " + ratInAMaze.ratInAMaze(maze1));
        System.out.println();

        // Test Case 2
        int maze2[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
        };
        System.out.println("Test Case 2:");
        System.out.println("Is there a path in maze 2? " + ratInAMaze.ratInAMaze(maze2));
        System.out.println();

        // Test Case 3
        int maze3[][] = {
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 1}
        };
        System.out.println("Test Case 3:");
        System.out.println("Is there a path in maze 3? " + ratInAMaze.ratInAMaze(maze3));
    }
}
