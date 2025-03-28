package GraphAdvance;

import java.util.Scanner;

/*Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph

Sample Output 1 :
0 0
1 3
2 4
3 5 */
public class dijkshtrasAlgorithm {
    private static void dijkstra(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		distance[0] = 0; //here we assume the first node to be the source
		for(int i = 1; i < v; i++){
			distance[i] = Integer.MAX_VALUE; //initilize all nodes distance to infinty
		}
		
		for(int i = 0; i < v - 1; i++){
			// Find Vertex with Min distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			// Explore neighbors
			for(int j = 0; j < v; j++){
                //here we take those nodes which are adjacent/neighbours and whcih are mot visisted
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
					int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    //if new distance is less, update it.
					if(newDist < distance[j]){
						distance[j] = newDist;
					}
				}
			}
		}
		
		// Print the shirtest dustance of all nodes from souce that is 0 in this case.
		for(int i = 0; i < v; i++){
			System.out.println(i + " "+ distance[i]);
		}
		
	}
    
    private static int findMinVertex(int[] distance, boolean visited[]) {
		
		int minVertex = -1;
		for(int i = 0; i < distance.length; i++){
            //in case of || if minVertex == -1 is true it wont go the 2nd case in case of Or
			if(!visited[i]  && (minVertex == -1 || distance[i] < distance[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt(); //V stands for number of vertices
		int e = s.nextInt(); //E stands for number of edges
        int adjacencyMatrix[][] = new int[v][v]; //create a adjaceny Matrix of v*V edges
        //taking Input for the graph
        //start from 0 to number of edges, not vertices
		for(int i = 0; i < e; i++){ 
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			adjacencyMatrix[v1][v2] = weight; //this applies only in case of undirected graphs
			adjacencyMatrix[v2][v1] = weight;
		}
		dijkstra(adjacencyMatrix);

     
	}
}
