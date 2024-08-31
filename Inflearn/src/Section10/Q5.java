package Section10;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    /**
     * 나의 구현방법 -> 못품
     * 강의해설 -> 주석으로 해설 적어놓음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] coins = new int[N]; // 입력받을 동전의 종류를 저장

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt(); // 동전의 종류를 입력받아서 저장
        }

        int M = sc.nextInt();
        int[] dy = new int[M + 1]; // 거스름돈 크기만큼 배열을 생성, + 1 한 이유는 배열의 인덱싱 때문

        Arrays.fill(dy, Integer.MAX_VALUE); // 모든 배열의 값을 가장 큰 값으로 설정, 가장 작은 값을 찾기 위해서 (초기 값은 0 이기 때문)
        dy[0] = 0; // 거스름 돈 0 은 0으로 초기화

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= M; j++) { // j는 coins[i]부터 시작, 동전의 크기 이전에는 못 쓰기 때문
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
                // dy[j - coins[i]] + 1의 의미는 coins[i]의 종류로 만들 수 있는 동전의 개수, + 1은 무조건 해당 종류의 동전을 사용한다는 의미
                // 그래서, dy[j - coins[i]]를 진행, 무조건 coins[i]를 하나 쓰니까 이전에 구해둔 최소 동전의 개수를 가져와서 + 1만 진행하면 됨
                // ex) 10원의 거스름돈을 5원의 동전으로 거슬러 주려면 최소 동전 개수를 사용하는가 ?
                // dy[10]은 dy[10 - 5] + 1과 같음. 5원 동전 하나는 쓰니까 -5한 값의 최소 동전 개수를 구하면 됨.
                // 근데 이미 dy[5]는 구해뒀기 때문에 값을 가져와서 더해주면 됨
            }
        }

        System.out.println(dy[M]);
    }
}
