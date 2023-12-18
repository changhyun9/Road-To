package Section5;

import java.util.Scanner;
import java.util.Stack;

public class Q3 {
    /**
     * 내가 구현한 방법
     * N, N x N 2차원 배열, M, M만큼의 moves를 입력받고
     * M만큼 반복문을 반복한다. 이때, 해당 moves[m]의 값이
     * 열의 값이 되고, 해당 열을 1부터 N까지 탐색한다.
     * 그때 0이 아닌 숫자를 만나면 stack의 마지막 값과 비교하여
     * 같으면 pop하고 result를 증가시키고, 같지 않으면 stack에 push한다.
     * 0이 아닌 숫자의 위치의 값을 0으로 변경하고 내부 반복문을 종료시킨다.
     * 모든 반복문이 끝나면 *2를 한 값을 출력한다. 터진 인형의 개수이므로 *2를하여
     * 결과를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
             moves[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < M; i++) {
            int cur = moves[i];
            for (int j = 1; j <= N; j++) {
                if (arr[j][cur] != 0) {
                    if ((!stack.isEmpty()) && (stack.peek() == arr[j][cur])) {
                        result++;
                        stack.pop();
                    } else {
                        stack.push(arr[j][cur]);
                    }
                    arr[j][cur] = 0;
                    break;
                }
            }
        }
        System.out.println(result*2);
    }
}
