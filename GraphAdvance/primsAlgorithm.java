package GraphAdvance;

import java.util.Scanner;

/*Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.



Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.



For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note: Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph



Sample Output 1 :
0 1 3
1 2 1
0 3 5 */
public class primsAlgorithm {
    private static void prims(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int weight[] = new int[v];
		int parent[] = new int[v];
		weight[0] = 0; //initialise weight for 1st as 0
		parent[0] = -1; //initialise parebt of first as -1
		for(int i = 1; i < v; i++){
			weight[i] = Integer.MAX_VALUE; //initialize weights of all vertices as Infinity
		}
        //here we loop vtimes from 0 to v-1
		for(int i = 0; i < v; i++){
			// Pick vertex with min weight
			int minVertex = findMinVertex(weight, visited);
			visited[minVertex] = true;
			// Explore its unvisited neighbors
			for(int j = 0; j < v; j++){
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j]){
					if(adjacencyMatrix[minVertex][j] < weight[j]){
                        //if weight is less, uodate the weight, and also update the parent
						weight[j] = adjacencyMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		
		// Print edges of MST
		for(int i = 1; i < v; i++){
            //print the nodes in increasing order lowest higest weight
			if(parent[i] < i){
				System.out.println(parent[i] + " "+ i +" "+ weight[i]);
			}else{
				System.out.println(i + " "+ parent[i] +" "+ weight[i]);
			}
		}
		
	}
    //A program to find minimum vertex from the unvisited with minimum weights
    private static int findMinVertex(int[] weight, boolean visited[]) {
		
		int minVertex = -1;
		for(int i = 0; i < weight.length; i++){
			if(!visited[i]  && (minVertex == -1 || weight[i] < weight[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt(); //v is the number of vertices
        int e = s.nextInt(); //e is the number of edges
        int adjacencyMatrix[][] = new int[v][v];
        //loop through the numver of edges to get input
        for(int i = 0; i < e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }

        prims(adjacencyMatrix);
    }
}
