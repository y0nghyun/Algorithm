import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] list;
	static int[] team;
	static ArrayList<Integer> isValidTeam;
	static ArrayList<Integer>[] teamScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new int[N];
			team = new int[201];
			isValidTeam = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				team[list[i]]++;
			}
			for (int i = 1; i < team.length; i++) {
				if (team[i] >= 6) {
					isValidTeam.add(i);
				}
			}
			teamScore = new ArrayList[201];
			int idx = 1;
			for (int i = 0; i < N; i++) {
				if (isValidTeam.contains(list[i])) {
					if (teamScore[list[i]] == null)
						teamScore[list[i]] = new ArrayList<>();
					teamScore[list[i]].add(idx);
					idx++;
				}
			}
			int winnerScore = Integer.MAX_VALUE;
			int winnerIdx = 0;
			for (int i = 1; i < teamScore.length; i++) {
				if (teamScore[i] != null && teamScore[i].size() >= 6) { // 팀의 점수가 6개 이상인지 확인
					int sum = 0;
					for (int j = 0; j < 4; j++) {
						sum += teamScore[i].get(j);
					}
					if (sum < winnerScore) {
						winnerScore = sum;
						winnerIdx = i;
					} else if (sum == winnerScore && teamScore[winnerIdx].get(4) > teamScore[i].get(4)) {
						winnerIdx = i;
					}
				}
			}
			System.out.println(winnerIdx);
		}

	}

}