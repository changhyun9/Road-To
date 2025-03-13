package Section2;

import java.util.Scanner;

public class Q2 {
    /**
     * 내가 구현한 방법
     * 나보다 앞에 있는 사람 중 가장 큰 사람과 비교해서
     * 더 크면 count를 증가시키고, 가장 큰 사람을 해당 사람의 키로 바꾼다
     * 또한, 첫번째 사람은 무조건 보이기 때문에 count를 1부터 시작했고,
     * 탐색 범위도 1부터 시작했다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = sc.nextInt();
        int[] array = new int[student];
        for (int i = 0; i < student; i++) {
            array[i] = sc.nextInt();
        }
        int count = 1;
        int max = array[0];
        for (int i = 1; i < student; i++) {
            if (max < array[i]) {
                max = array[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
