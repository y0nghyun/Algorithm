import java.lang.*;
import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int end;
        int cost;
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return cost - o.cost;
        }
    }
    
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] list;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        visited = new boolean[N+1];
        dist = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<road.length; i++){
            Node temp = new Node(road[i][1], road[i][2]);
            list[road[i][0]].add(temp);
            temp = new Node(road[i][0],road[i][2]);
            list[road[i][1]].add(temp);
        }
        dijkstra();
    
        for(int i=0; i<N+1; i++){
            if(dist[i] <= K)
                answer++;
        }
        return answer;
    }
    
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,1));
		dist[1] = 0;
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
    }
}