import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	static ArrayList<Node>[] graph;
	static int[] sd;
	static int[] ld;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		sd = new int[n+1];
		ld = new int[n+1];
		int max = Integer.MAX_VALUE;
		
		
		for(int i=1; i<n+1; i++)
			graph[i] = new ArrayList<Node>();
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, weight));
		}
		int dist[] = new int[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=1; i<n+1; i++){
			if(i == x) continue;
			Arrays.fill(dist, max);
			boolean[] visited = new boolean[n+1];
			pq.add(new Node(i,0));
			dist[i] = 0;
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();
				int cur = tmp.end;
				if(visited[cur] == true) continue;
				visited[cur] = true;
				for(Node node : graph[cur]) {
					if(dist[node.end] > dist[cur] + node.cost ) {
						dist[node.end] = dist[cur] + node.cost;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
				
			}
			sd[i] = dist[x];
		}
		boolean[] visited = new boolean[n+1];
		pq.add(new Node(x,0));
		Arrays.fill(ld, max);
		ld[x] = 0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int cur = tmp.end;
			if(visited[cur] == true) continue;
			visited[cur] = true;
			for(Node node : graph[cur]) {
				if(ld[node.end] > ld[cur] + node.cost ) {
					ld[node.end] = ld[cur] + node.cost;
					pq.add(new Node(node.end, ld[node.end]));
				}
			}
		}
		int ans = 0;
		for(int i=1;i<n+1;i++) {
			if(i == x) continue;
			sd[i] += ld[i];
			
			if(ans < sd[i])
				ans = sd[i];
		}
		System.out.println(ans);
		
		
	}

}
