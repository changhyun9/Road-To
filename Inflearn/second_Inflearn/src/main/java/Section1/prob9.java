package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int answer = Integer.parseInt(input.replaceAll("[^0-9]", ""));

        System.out.println(answer);

        answer = 0;

        // 여러가지 방법이 있을 것 같은데, 우선 replaceAll을 이용해서 숫자가 아니면 모두 제거해서 Integer.parseInt() 사용
        // 앞에서부터 차례대로 보면서 숫자인것만 추출해서 문자열 구성
        // 강의 해설은 answer = answer *10 + (x-'0') 하면서 자릿수를 늘려나감
        // 그리고 문자열을 toCharArray()를 사용해서 for-each 문을 주로 사용
        for (char x : input.toCharArray()) {
            if(x>=48 && x<=57) answer = answer*10 +(x-'0');
        }

        System.out.println(answer);

    }
}
