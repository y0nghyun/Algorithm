import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int to;
		int from;
		int weight;

		public Edge(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static int V;
	static int E;
	static int[] parent;

	static PriorityQueue<Edge> q;

	private static void init() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA < rootB)
			parent[rootA] = rootB;
		else
			parent[rootB] = rootA;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		q = new PriorityQueue<>();

		init();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			q.add(new Edge(to, from, weight));
		}
		int ans = 0;
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				ans += cur.weight;
			}
		}
		System.out.println(ans);
	}

}