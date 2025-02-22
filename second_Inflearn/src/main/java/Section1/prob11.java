package Section1;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        char ch = input.charAt(0);
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                cnt++;
            } else {
                if (cnt == 1) {
                    sb.append(ch);
                } else {
                    sb.append(ch).append(cnt);
                }
                ch = input.charAt(i);
                cnt = 1;
            }
        }

        if (cnt == 1) {
            sb.append(ch);
        } else {
            sb.append(ch).append(cnt);
        }


        // 강의 해설은 i랑 i+1를 직접 비교해서 같은지, 다른지 판단 후에 각각의 로직이 돌아감.
        // 그래서 이때 중요한것은 입력받은 문자열 맨 마지막에 " ", 빈 문자열을 추가해주는 것

        input = input + " ";
        int count = 1;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if(input.charAt(i) == input.charAt(i+1)) count++;
            else{
                answer.append(input.charAt(i));
                if(count>1) answer.append(count);
                count = 1;
            }
        }

        System.out.println(sb);
    }
}
