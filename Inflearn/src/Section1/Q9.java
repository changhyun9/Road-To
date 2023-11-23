package Section1;

import java.util.Scanner;

public class Q9 {
    /**
     * 내가 구현한 방법
     * 문자열을 하나씩 돌면서 숫자인 경우에만
     * 문자열 연산을 함. 이후, 문자열을 int로 바꾸면
     * 앞에 0 까지 없애고 변환 가능
     */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String temp = "";
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if (Character.isDigit(c)) {
                temp += c;
            }
        }
        int answer = Integer.parseInt(temp);
        System.out.println(answer);
    }

    /**
     * '0' -> 48, '9' -> 57 아스키코드를 이용하여
     * 범위 안에 들어오면 숫자이기 때문에 값을 누적시켜준다
     * answer * 10 을 통해 자리수를 늘려주고
     * 뒤에 x-48 을 하여 문자를 숫자로 변환하고 더해준다.
     */
   /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int answer =0;
        for (char x : next.toCharArray()) {
            if(x>=48 && x <= 57){
                answer = answer * 10 + (x - 48);
            }
        }

        System.out.println(answer);
    }*/
}
