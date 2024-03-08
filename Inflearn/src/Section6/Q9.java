package Section6;

import java.util.Arrays;
import java.util.Scanner;

public class Q9 {
    /**
     * 내가 구현한 방법 -> 못풀어서 강의들음
     * 강의 구현법 -> 결정 알고리즘 (이분탐색)을 이용하여 구현
     * 결정 알고리즘은 구간 내 확실한 정답이 존재할 때만 사용
     * 결정 알고리즘은 구간 내 요소가 정렬되어 있을 때만 사용
     * 해결 로직은 용량을 설정하고, 모든 요소를 M개에 담을 수 있다면
     * 작은 범위를 탐색하고, 담을 수 없다면 큰 범위를 탐색한다.
     * M개에 담을 수 있는지 판단하는 방법은 모든 요소를 해당 용량으로
     * 담았을 때 나오는 DVD 개수로 판단
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= M) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if ((sum + x) > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
