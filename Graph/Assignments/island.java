package Graph.Assignments;

import java.util.Scanner;

/*Problem statement
An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 0 to V-1) and E connections or edges between islands. Can you count the number of connected groups of islands.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1  */
public class island {
    public static int numConnected(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                helpDFS(edges, visited, i, n);
            }
        }
        return count;
    }

    public static void helpDFS(int edges[][], boolean visited[], int start, int n) {
        visited[start] = true;
        for (int j = 0; j < n; j++) {
            if (edges[start][j] == 1 && !visited[j]) {
                helpDFS(edges, visited, j, n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // number of vertices (islands)
        int E = sc.nextInt(); // number of edges (connections)

        int[][] edges = new int[V][V];

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            edges[start][end] = 1;
            edges[end][start] = 1;
        }

        int result = numConnected(edges, V);
        System.out.println(result);
    }
}
