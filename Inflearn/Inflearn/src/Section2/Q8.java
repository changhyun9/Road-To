package Section2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q8 {
    /**
     * 내가 구현한 방법
     * 점수를 입력받고, 입력받은 점수들을 내림차순으로 정렬했다
     * 이후, 원래 입력받은 점수 배열을 돌면서 해당 점수가
     * 정렬 시에 어느 인덱스에 해당하는 지 출력함.
     * 출력 시에는 인덱스 이므로 +1를 해줌.
     * 또한, int[] 배열로 점수를 받았는데, int[]형은 오름차순 정렬은
     * 되지만, 내림차순 정렬은 안돼서 stream을 이용해서 Integer[]로 박싱해줌.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] score = new int[count];
        for (int i = 0; i < count; i++) {
            score[i] = sc.nextInt();
        }
        Integer[] sortArray = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sortArray, Collections.reverseOrder());

        for (int i = 0; i < count; i++) {
            int index = Arrays.asList(sortArray).indexOf(score[i]);
            System.out.print(index+1 + " ");
        }
    }

    /**
     * 점수를 입력받고, 이중 포문을 돌면서 등수를 판정한다.
     * 이중 포문을 돌면서, 점수 하나를 기준으로 잡고, 모든 점수들과 비교하여
     * 큰 경우에만 등수를 하나 증가시킨다. 모든 판정이 끝나면, 등수를 해당 인덱스에
     * 삽입하고, 다시 등수는 1로 초기화한다
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] score = new int[count];
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < count; i++) {
            int cnt = 1;
            for (int j = 0; j < count; j++) {
                if (score[j] > score[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        for (int one : answer) {
            System.out.print(one + " ");
        }
    }*/
}
