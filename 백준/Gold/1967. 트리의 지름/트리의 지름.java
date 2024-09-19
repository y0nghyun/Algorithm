import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int dt;
		int cost;
		
		Node(int dt, int cost){
			this.dt = dt;
			this.cost = cost;
		}
	}
	static boolean[] visited;
	static ArrayList<Node>[] nl;
	static int max = 0;
	static int tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1) {
			System.out.println(0);
			return;
		}
		nl = new ArrayList[n+1];
		for(int i=1;i<n+1;i++)
			nl[i] = new ArrayList<Node>();
		for(int i=1;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			nl[a].add(new Node(b,value));
			nl[b].add(new Node(a,value));
		}
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1,0);
		
		visited = new boolean[n+1];
		visited[tmp] = true;
		dfs(tmp,0);
		
		System.out.println(max);
	}
	static void dfs(int point, int total) {
		if ( max < total) {
			max = total;
			tmp = point;
		}
		for(int i=0; i<nl[point].size();i++) {
			if(visited[nl[point].get(i).dt] == false) {
				visited[nl[point].get(i).dt] = true;
				dfs(nl[point].get(i).dt, total + nl[point].get(i).cost);
			}
		}
	
	
	}

}
