package LV1;

import java.util.Scanner;

public class prob11 {
    /**
     * 문제명 : 주행거리 비교하기
     * 나의 풀이 방법 : 단순히 if문으로 비교하여 출력, 더 코드 수를 줄이려면 중첩 ?조건문 사용하면 될듯
     * ex) (i > j ) ? A : ((i == j) ? "same" : B )
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        if (i - j != 0)
            System.out.println(i > j ? "A" : "B");
        else {
            System.out.println("same");
        }
    }
}
