package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob8 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        input = input.toLowerCase();


        // 밑의 코드처럼 lt, rt를 두고 풀어도 되지만, 간단하게 replaceAll 이용하애서 대문자, 혹은 소문자가
        // 아닌 문자열은 지우고, StringBuilder 를 이용해서 reverse() 메서드를 사용 및 비교 하는 방법이 있음.
        int lt = 0, rt = input.length() - 1;
        String answer = "YES";

        while (lt < rt) {
            if (!Character.isAlphabetic(input.charAt(lt))) {
                lt++;
            }
            else if(!Character.isAlphabetic(input.charAt(rt))) {
                rt--;
            }
            else  {
                if (input.charAt(lt) != input.charAt(rt)) {
                    answer = "NO";
                    break;
                }
                lt++;
                rt--;
            }
        }

        // 강의 해설 replaceAll을 이용해서 대문자, 혹은 소문자가 아닌 문자열은 다 지우고
        // StringBuilder 의 reverse()를 이용해서 팰린드롬인지 비교

        input = input.toLowerCase().replaceAll("[^a-z]", "");
        String temp = new StringBuilder(input).reverse().toString();
        if (!input.equals(temp)) {
            answer = "NO";
        }

        System.out.println(answer);

    }
}
