package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        // 두가지 방식으로 구현이 가능할 것 같다. 간단하게 소문자로 모두 바꾼 뒤,
        // StringBuilder의 reverse() 를 이용해서 equals() 비교
        // StringBuilder의 equals 는 재정의해서 사용해야함.
        input = input.toLowerCase();

        String temp = new StringBuilder(input).reverse().toString();
        if (temp.equals(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // 또 다른 하나는, lt, rt를 이용해서 직접 대응되는 위치에 같은지 비교

        input = input.toLowerCase();
        boolean flag = true;
        int lt = 0, rt = input.length() - 1;
        while (lt < rt) {
            if (input.charAt(lt) == input.charAt(rt)) {
                lt++;
                rt--;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // 강의 해설은 어차피 위치가 일대일 대응으로 움직이므로 0 인덱스는 len-1 이랑, 1 인덱스는 len - 2랑 대응
        // 그래서 for문을 len /2 까지만 돌면 된다.
        String answer = "YES";
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);


    }
}
