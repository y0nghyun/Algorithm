import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemKinds.size();

        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int[] answer = {0, gems.length - 1};

        while (true) {
            if (map.size() == totalKinds) {
                if (right - left - 1 < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }

                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }
                left++;
            }
            else if (right == gems.length) {
                break;
            } else {
                String rightGem = gems[right];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }

        return new int[]{answer[0] + 1, answer[1] + 1};
    }
}
