package Section2;

import java.util.Scanner;

public class Q1 {
    /**
     * 내가 구현한 방법
     * (i-1)번째 값과 (i)번째 값을 비교해서 큰 값만 answer로 출력한다
     * -1 -> 앞의 인덱스를 참조하기 때문에 0이 아닌 1부터 시작했고,
     * 맨 앞의 수는 무조건 출력되므로 answer에 포함시켜놨다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        answer += array[0] + " ";
        for (int i = 1; i < N; i++) {
            if(array[i-1] < array[i]){
                answer += array[i] + " ";
            }
        }
        System.out.println(answer);
    }
}
