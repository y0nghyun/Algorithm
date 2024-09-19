import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] graph = new int[n+1][n+1];
		int max = Integer.MAX_VALUE;
		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++) {
				if(i == j) continue;
				graph[i][j] = max;
			}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start][end] = Math.min(graph[start][end],weight);
		}
		for(int i=1; i<n+1; i++)
			for(int j=1; j<n+1; j++)
				for(int k=1; k<n+1; k++) {
					if(i == j || i == k || j ==k) continue;
					if(graph[j][i] != max && graph[i][k] != max) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1;j++) {
				if(graph[i][j] == max)
					System.out.print(0 + " ");
				else
					System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	
	}

}
