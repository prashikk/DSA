package Graph.Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class threeCycles {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int solve(boolean[][] graph, int n) {
		/*
		 * Your class should be named Solution 
		 * You may write your code here
		 */
		     int count=0;
        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph.length;j++) {
                if(graph[i][j] ==true) {

                    for(int k=0;k<graph.length;k++) {

                        if(k!=i && graph[k][j]==true && graph[i][k] ==true ) {
                            count++;
                        }


                    }

                }
            }
        }
        return count/6; 

	}

	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
}
