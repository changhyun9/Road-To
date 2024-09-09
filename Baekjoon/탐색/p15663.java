package 탐색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p15663 {
    /**
     * 나의 구현방법
     * 순차적으로 접근을 했다. 우선 조합을 구현하는 로직을 작성하였고, DFS와 check, numbers 배열로
     * 조합 구현은 성공하였다. 이후, 중복을 제외하고 출력하는 로직을 생각하는데 시간이 오래 걸렸다.
     * String과 List를 사용하여 이미 포함되어 있는지 확인했다. 중복을 제거하는데는 성공했지만, 한자리수만
     * 고려했기에 실패했다. 이후, 조합 배열이 다 찼을 경우 " " (공백)을 포함해서 더하는 걸로 한자리수 이상 조건도
     * 성공하였지만, 시간초과와 출력 초과가 발생하였다. 처음엔 DFS 분기가 문제인 줄 알았는데, 질문 게시판의 힌트를 통해
     * Set를 이용하여 조합 중복이 일어났는지 확인하였더니, 시간 초과를 해결할 수 있었다.
     *
     * 구현방법은 수 입력 -> 수 오름차순 정렬 -> DFS -> 조합 구현 -> Set를 이용하여 중복 제거 및 출력
     */
    static int N, M;
    static int[] check, numbers;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        check = new int[N];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            check[i] =1;
            arr[cnt] = numbers[i];
            DFS(cnt+1);
            check[i] =0;
        }

    }

    public static void DFS(int cnt) {
        if (cnt == M) {
            String temp = "";
            for (int i = 0; i < M; i++) {
                temp += arr[i] + " ";
            }
            if (!set.contains(temp)) {
                set.add(temp);
                System.out.println(temp);
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    arr[cnt] = numbers[i];
                    DFS(cnt+1);
                    check[i] = 0;
                }
            }
        }
    }
}