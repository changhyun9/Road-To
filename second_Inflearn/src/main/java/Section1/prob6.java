package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];

        // 내가 푼 방식은 미리 알파벳 배열을 만들어놓고 앞에서 나왔는지 체크 -> 강의 해설이랑 비교하면 메모리적으로 비효율적
        for (int i = 0; i < input.length(); i++) {
            if (alphabet[input.charAt(i) - 'a'] == 0) {
                sb.append(input.charAt(i));
                alphabet[input.charAt(i) - 'a']++;
            }
        }

        // 강의 해설은 indexOf를 이용해서 현재 index랑 알파벳이 처음 나오는 인덱스랑 비교해서 중복체크
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) {
                sb.append(input.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
