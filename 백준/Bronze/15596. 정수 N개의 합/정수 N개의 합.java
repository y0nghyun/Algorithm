public class Test {
    long sum(int[] a) {
        long result = 0; // 합을 저장할 변수, long 타입을 사용하여 오버플로우 방지
        for (int num : a) {
            result += num;
        }
        return result;
    }
}