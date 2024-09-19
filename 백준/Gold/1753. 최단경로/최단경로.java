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
	static ArrayList<Node>[] list;
	static int[] dist;
	static int max = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		list = new ArrayList[v+1];
		dist = new int[v+1];
		Arrays.fill(dist, max);
		for(int i=1; i<list.length;i++)
			list[i] = new ArrayList<Node>(); 
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,value));
		}
		if(v==1) {
			System.out.println(0);
			return;
		}
		boolean[] visited = new boolean[v+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int cur = tmp.end;
			if(visited[cur] == true) 
				continue;
			visited[cur] = true;
			for(int i=0; i<list[cur].size(); i++) {
				if(dist[list[cur].get(i).end] > dist[cur] + list[cur].get(i).cost) {
					dist[list[cur].get(i).end] = dist[cur] + list[cur].get(i).cost; 
					pq.add(new Node(list[cur].get(i).end,dist[list[cur].get(i).end]));
				}
			}
		}
		for(int i=1; i<dist.length;i++) {
			if(dist[i] == max)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
	}
	

}
