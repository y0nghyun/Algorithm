import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Country implements Comparable<Country> {
		int num, gold, silver, bronze;

		public Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Country o) {
			if (this.gold != o.gold) {
				return o.gold - this.gold;
			}
			if (this.silver != o.silver) {
				return o.silver - this.silver;
			}
			if (this.bronze != o.bronze) {
				return o.bronze - this.bronze;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Country> countries = new ArrayList<>();
		Country target = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			Country country = new Country(num, gold, silver, bronze);
			countries.add(country);
			if (num == k) {
				target = country;
			}
		}

		Collections.sort(countries);

		int rank = 1;
		int sameRankCount = 1;

		for (int i = 0; i < countries.size(); i++) {
			if (i > 0 && countries.get(i).compareTo(countries.get(i - 1)) != 0) {
				rank += sameRankCount;
				sameRankCount = 1;
			} else if (i > 0) {
				sameRankCount++;
			}

			if (countries.get(i).num == target.num) {
				System.out.println(rank);
				break;
			}
		}
	}
}