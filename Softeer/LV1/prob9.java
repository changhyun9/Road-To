package LV1;

import java.util.Scanner;

public class prob9 {
    /**
     * 문제명 : A+B
     * 나의 풀이 방법 : 입력된 A와 B를 더한후 형식에 맞춰 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case #" + (i+1) + ": " + (a+b));
        }
    }
}
