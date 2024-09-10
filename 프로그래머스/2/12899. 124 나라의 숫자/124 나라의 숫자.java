class Solution {
	public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
		while (n > 0) {
			if (n % 3 == 0) {
				n--;
				sb.append(4);
			} else {
				sb.append(n%3);
			}
			n /= 3;
		}
		return sb.reverse().toString();
	}
}