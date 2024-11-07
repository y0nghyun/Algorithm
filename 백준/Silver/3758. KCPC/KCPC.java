import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Team implements Comparable<Team> {
		int teamNum;
		int[] score;
		int cnt;
		int lastSubmitTime;
		int totalScore;

		public Team(int teamNum, int scoreSize) {
			this.teamNum = teamNum;
			score = new int[scoreSize + 1];
			this.totalScore = 0;
			this.cnt = 0;
			this.lastSubmitTime = 0;
		}

		@Override
		public int compareTo(Team o) {
			if (this.totalScore != o.totalScore) {
				return Integer.compare(o.totalScore, this.totalScore);
			}
			if (this.cnt != o.cnt) {
				return Integer.compare(this.cnt, o.cnt);
			}
			return Integer.compare(this.lastSubmitTime, o.lastSubmitTime);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<Team> teams = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				teams.add(new Team(j, k));
			}
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int teamId = Integer.parseInt(st.nextToken());
				int problemNum = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				teams.get(teamId).cnt++;
				teams.get(teamId).lastSubmitTime = j;
				int temp = teams.get(teamId).score[problemNum];
				teams.get(teamId).score[problemNum] = temp > score ? temp : score;
			}
			for (int a = 1; a < teams.size(); a++) {
				int sum = 0;
				for (int b = 1; b < k + 1; b++) {
					sum += teams.get(a).score[b];
				}
				teams.get(a).totalScore = sum;
			}
			Collections.sort(teams);
			for (int j = 0; j < teams.size(); j++) {
				if (teams.get(j).teamNum == t) {
					System.out.println(j + 1);
					break;
				}
			}

		}
	}

}