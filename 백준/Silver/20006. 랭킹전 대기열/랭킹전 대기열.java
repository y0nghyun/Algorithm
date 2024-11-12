import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Player implements Comparable<Player> {
		int level;
		String name;

		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}
	}

	static int p;
	static int m;

	static ArrayList<ArrayList<Player>> room = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		room = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int level = Integer.parseInt(st.nextToken());
		String name = st.nextToken();
		for (int i = 0; i < p; i++) {
			room.add(new ArrayList<>());
		}
		room.get(0).add(new Player(level, name));
		for (int i = 1; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			level = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			for (int j = 0; j < room.size(); j++) {
				if (room.get(j).size() >= m)
					continue;
				if (room.get(j).size() == 0) {
					room.get(j).add(new Player(level, name));
					break;
				}
				if (room.get(j).get(0).level - 10 <= level && room.get(j).get(0).level + 10 >= level) {
					room.get(j).add(new Player(level, name));
					break;
				}
			}
		}
		for (int i = 0; i < room.size(); i++) {
			if (room.get(i).size() == 0)
				break;
			Collections.sort(room.get(i));
			if (room.get(i).size() == m)
				System.out.println("Started!");
			else
				System.out.println("Waiting!");
			for (int j = 0; j < room.get(i).size(); j++) {
				System.out.println(room.get(i).get(j).level + " " + room.get(i).get(j).name);
			}
		}
	}

}