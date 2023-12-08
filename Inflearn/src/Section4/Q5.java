package Section4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q5 {
    /**
     * 내가 구현한 방법
     * N의 최대 크기가 100이라서 3중 for문을 사용해도 시간초과가 발생하지 않을 것이라고 생각
     * 그래서 3중 for문으로 모든 경우의 수를 구해서 list로 저장. 이후 list를 set으로 변환해서
     * 중복 값을 제거함. 다시 set을 list로 변환해서 K 번째 큰 수를 구함. 만약 set에 저장된 값의 크기들
     * 보다 K가 더 크면 -1 반환
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    result.add(temp);
                }
            }
        }
        Set<Integer> set = new HashSet<>(result);
        Integer[] integers = set.toArray(new Integer[0]);
        if (K > integers.length) {
            System.out.println("-1");
        } else {
            System.out.println(integers[integers.length - K]);
        }
    }
}
