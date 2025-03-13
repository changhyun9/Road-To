package Section6;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    /**
     * 나의 구현방법
     * 입력받은 배열을 복사하여 복사된 배열을 정렬한다.
     * 이후 입력받는 원본 배열과 복사되어 정렬된 배열을
     * 인덱스를 앞에서부터 뒤까지 비교하여 같은 인덱스에
     * 다른 값이 들어가있는 인덱스를 결과로 출력한다.
     * 강의 해설도 나와 같이 품.
     * 대신 정답을 배열에 담는 것이 아닌 ArrayList를
     * 생성해서 담음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] copyArr = new int[N];
        int[] answer = new int[2];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        for (int i = 0; i < N; i++) {
            if (arr[i] != copy[i]) {
                answer[cnt] = i + 1;
                cnt++;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
