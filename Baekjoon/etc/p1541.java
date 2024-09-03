package etc;

import java.util.Scanner;

public class p1541 {
    /**
     * 나의 구현방법 -> 못품, -0 경우를 캐치하지 못함.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // 입력값을 한 문장으로 받아서 저장
        int answer =Integer.MAX_VALUE; // 아무런 값이 저장되어 있지 않은 상태를 나타냄

        String[] split = input.split("-"); // ex) 55-50+40 => 55-(50+40)로 만들기 위해 '-'를 이용하여 분할
                                                 // 덧셈으로 이루어진 부분을 최대로 만들어 나중에 '-'를 사용

        for (int i = 0; i<split.length; i++) { // '-'를 기준으로 생긴 부분, 즉 '+' 덧셈으로만 이루어진 부분

            int temp = 0;

            String[] str = split[i].split("\\+"); // 각 수를 더하기 위해 분할

            for (int j = 0; j < str.length; j++) {
                temp += Integer.parseInt(str[j]); // 하나씩 분할하여 정수로 바꾼 뒤 더함
            }

            if (answer == Integer.MAX_VALUE) { // 아무런 값이 저장이 안된 상태, 즉 맨처음을 저장, 무조건 맨처음은 양수
                answer = temp;
            } else {
                answer -= temp; // 덧셈으로 된 부분은 다 더해서 temp에 저장하였으니, 처음 '-'로 나눴기에 뺄셈
            }
        }

        System.out.println(answer);
    }
}
