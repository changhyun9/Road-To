package Section2;

import java.util.Scanner;

public class Q7 {
    /**
     * 내가 구현한 방법
     * 점수를 입력받고, 반복문을 돌면서 1이면 점수를
     * 증가하고 총점에 저장한다. 만약 0이면 점수를 0으로만
     * 바꾸고 넘어간다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] correct = new int[count];
        int sum = 0;
        int score = 0;
        for (int i = 0; i < count; i++) {
            correct[i] = sc.nextInt();
        }
        for (int i = 0; i < count; i++) {
            if (correct[i] == 1) {
                sum += ++score;
            }
            else{
                score = 0;
            }
        }
        System.out.println(sum);
    }
}
