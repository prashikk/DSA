package Graph.Assignments;
import java.util.*;
/*Problem statement
Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:

1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2 */
public class BFS {
    
	 public static void printHelper(int edges[][], int sv,boolean visited[]){ //here sv is the vertex passed to the print function
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while(q.size()!=0){
            int firstelem = q.poll(); //here both poll and remove can be used, both remove and return the first element of the queue
            System.out.print(firstelem+" ");
            for(int i=0; i<edges.length; i++){
                if(edges[firstelem][i]==1 && !visited[i]){ //check for all neighbours of firstElement if they have an edge and are not visited put them in the queue
                    q.add(i);
                    visited[i]=true;
                }       
            }
        }   
    }
    // we have to deal with both connected and non connected
    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length]; //here edges.length is the number of vertices
        //here we loop through all the vertices if they are not visitied call the print helper function on it, to solve the problem of unconnected graphs
        for(int i=0; i< edges.length; i++){
            if(!visited[i]){
                printHelper(edges, i, visited);   
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        int[][] edges = new int[V][V];

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            edges[start][end] = 1;
            edges[end][start] = 1;
        }

        print(edges);
    }
}
