import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ans =bfs(n,k);
		System.out.println(ans);
	}
	public static int bfs(int n, int k) {
		int cnt[] = new int[100001];
		boolean visited[] = new boolean[100001];
		int ans = 0;
		int num;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(n);
		cnt[n] = 0;
		while(!q.isEmpty()){
			
			num = q.peek();
			if(q.remove() == k) {
				ans = cnt[k];
				return ans;
			}
			if(num*2 <100001) {
				if(visited[num*2] == false) {
					cnt[num*2] = cnt[num];
					visited[num*2] = true;
					q.add(num*2);
				}
				else if(cnt[num*2] > cnt[num]) {
					cnt[num*2] = cnt[num];
				}
			}
			if(num+1 <100001) {
				if(visited[num+1] == false) {
					cnt[num+1] = cnt[num] + 1;
					visited[num+1] = true;
					q.add(num+1);
				}
				else if(cnt[num+1] > cnt[num] + 1) {
					cnt[num+1] = cnt[num] + 1;
				}
			}
			if(num-1 >= 0 ) {
				if(visited[num-1] == false) {
					cnt[num-1] = cnt[num] + 1;
					visited[num-1] = true;
					q.add(num-1);
				}
				else if(cnt[num-1] > cnt[num] + 1) {
					cnt[num-1] = cnt[num] + 1;
				}
			}
			
		}
	
		return -1;
	}
}
