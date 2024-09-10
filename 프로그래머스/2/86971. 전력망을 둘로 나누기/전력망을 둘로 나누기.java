import java.util.*;
import java.lang.*;

class Solution {
    
    static int size;
    static boolean[][] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        size = n;
        
        graph = new boolean[n+1][n+1];
        for(int i=0; i<n-1; i++){
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
        }
        for(int i=0; i<n-1; i++){
            int cnt = 0;
            visited = new boolean[n+1];
            graph[wires[i][0]][wires[i][1]] = false;
            graph[wires[i][1]][wires[i][0]] = false;
            find(wires[i][0]);
            for(int j=0; j<n+1; j++){
                if(visited[j])
                    cnt++;
            }
            answer = Math.min(answer, Math.abs(n-cnt-cnt));
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
        }
        return answer;
    }
    
    private static void find(int num){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(num);
        visited[num] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<size+1; i++){
                if(graph[temp][i] && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
    }
    
}