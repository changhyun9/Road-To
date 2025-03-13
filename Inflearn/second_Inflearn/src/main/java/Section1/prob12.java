package Section1;

import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        // replaceAll 정규식 사용, replace는 단순 문자 사용
        input = input.replace("#", "1").replace("*", "0");

        for (int i = 0; i < n; i++) {
            char ch = (char)Integer.parseInt(input.substring(0,7), 2); // 2진수 -> 10진수 변환 방법을 몰라서 틀림
            input = input.substring(7);
            sb.append(ch);
        }


        System.out.println(sb);


    }

}
