class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 0;

        for (int s : stones) right = Math.max(right, s);

        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone < people) {     
                cnt++;
                if (cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}
