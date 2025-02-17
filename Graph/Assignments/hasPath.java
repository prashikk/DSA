package Graph.Assignments;
import java.io.IOException;
import java.util.*;
/*Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false */
public class hasPath {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		 Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int edges[][]=new int[V][V];
        for(int i=0;i<E;i++){
            int sv=s.nextInt();
            int ev=s.nextInt();
            edges[sv][ev]=1;
            edges[ev][sv]=1;
        }
        int V1=s.nextInt();
        int V2=s.nextInt();
        if(V2>=V){ //this we are checking for aray index out of boounds exception
            System.out.println("false");
            return;
        }
        boolean visited[]=new boolean[V];
        
        boolean ans=hasPath(edges,V1,V2,visited);
        System.out.println(ans);

	}

	    public static boolean hasPath(int[][] edges,int V1, int V2,boolean visited[]){
        if(V1>edges.length || V2>edges.length){
            return false;
        }  
        if(edges[V1][V2]==1)
            return true;
        Queue<Integer> q=new LinkedList<>();
        q.add(V1);
        visited[V1]=true;
        while(!q.isEmpty()){
            int n=q.remove();
            for(int i=0;i<edges.length;i++)
            {
             if(edges[n][i]==1 && !visited[i])
             {
                 q.add(i);
                 visited[i]=true;
             }
            }
        }
        if(visited[V2]==true)
            return true;
        else
            return false;
    }
}
