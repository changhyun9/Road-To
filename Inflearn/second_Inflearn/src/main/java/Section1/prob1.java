package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine().toLowerCase();
        char ch = bf.readLine().toLowerCase().charAt(0);
        int answer = 0;


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
