package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        // 방법은 두가지 index 역순으로 접근해서 하나씩 += 해주기 -> 메모리나 시간적으로 비효율적
        // 다른 하나는 StringBuilder 클래스의 reverse() 메서드를 사용
        for (int i = 0; i < n; i++) {
            StringBuilder input = new StringBuilder(bf.readLine());
            System.out.println(input.reverse());
        }

        // lt와 rt를 이용해서 직접 reverse() 메서드 기능 구현 -> 인프런 해설
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            char[] array = input.toCharArray();
            int lt = 0, rt = array.length - 1;
            while (lt < rt) {
                char tmp = array[lt];
                array[lt] = array[rt];
                array[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(String.valueOf(array));
        }
    }
}
