package Section8;

import java.util.Scanner;

public class Q1 {
    /**
     * 풀이 방법
     * 해당 레벨 즉 배열의 인덱스 값으로 사용하는지, 안하는지 가지를 나눠 재귀를 진행한다.
     * 깊이 우선 탐색 이므로, 말단 노드에 도착했을 때 사용한다에 체크된 sum 을 모두 더해서
     * total - sum == sum과 같으면 두개의 부분 집합으로 나눠진 상태고,
     * 두 부분 집합의 합이 같은 경우이므로 YES를 return
     * 말단노드에 도착해서 두개의 부분집합이 값이 같은지 확인 했을 때
     * true가 나오면 그 즉시 재귀를 멈춘다.
     */
    static int[] arr;
    static int N;
    static int total;
    static String answer = "NO";
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0, 0);
        System.out.println(answer);

    }

    public static void DFS(int L, int sum) {
        if (flag) return;
        if(sum > total/2) return;
        if (L == N) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum+arr[L]);
            DFS(L + 1, sum);
        }
    }
}
