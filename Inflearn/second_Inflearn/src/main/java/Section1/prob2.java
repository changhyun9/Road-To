package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                sb.append(Character.toLowerCase(input.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(input.charAt(i)));
            }
        }

        System.out.println(sb.toString());
    }
}
