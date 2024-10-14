import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Cell implements Comparable<Cell> {
		int x, y, life, activeTime, remainLife;
		boolean isActive;

		public Cell(int x, int y, int life) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.activeTime = life;
			this.remainLife = life;
			this.isActive = false; // 활성화 여부
		}

		// 세포의 생명력이 높은 순서대로 번식
		@Override
		public int compareTo(Cell other) {
			return other.life - this.life;
		}
	}

	static int N, M, K;
	static int[][] graph;
	static List<Cell> cells;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	// 세포 번식 및 상태 변화 처리
	private static void simulate() {
		List<Cell> newCells = new ArrayList<>(); // 새로운 세포를 저장할 리스트

		for (Cell cell : cells) {
			if (!cell.isActive) {
				// 세포가 아직 비활성화 상태이면 활성화 시간 감소
				cell.activeTime--;
				if (cell.activeTime == 0) {
					cell.isActive = true; // 세포 활성화
				}
			} else if (cell.remainLife > 0) {
				// 세포가 활성화 상태이고 남은 생명력이 있으면 번식
				for (int i = 0; i < 4; i++) {
					int nx = cell.x + dx[i];
					int ny = cell.y + dy[i];
					if (graph[nx][ny] == 0) {
						// 번식 가능한 빈 공간에 새로운 세포 생성
						newCells.add(new Cell(nx, ny, cell.life));
						graph[nx][ny] = cell.life;
					}
				}
				// 활성화된 세포의 생명력 감소
				cell.remainLife--;
			}
		}

		// 새롭게 번식한 세포를 기존 리스트에 추가
		cells.addAll(newCells);
	}

	// 생존한 세포 수 계산
	private static int countAliveCells() {
		int count = 0;
		for (Cell cell : cells) {
			if (cell.remainLife > 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= tNum; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// 배열 크기 설정 (K만큼 여유 공간을 두고 초기화)
			graph = new int[N + 2 * K][M + 2 * K];
			cells = new ArrayList<>();

			// 세포 정보 입력
			for (int i = K; i < K + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K; j < K + M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life > 0) {
						graph[i][j] = life;
						cells.add(new Cell(i, j, life)); // 세포 추가
					}
				}
			}

			// K 시간 동안 시뮬레이션 실행
			for (int time = 1; time <= K; time++) {
				simulate(); // 매 시간마다 세포 번식 및 상태 갱신
			}

			// 결과 출력
			System.out.println("#" + TC + " " + countAliveCells());
		}
	}
}