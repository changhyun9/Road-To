package Section3;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int answer = 0, lt = 1, sum = 0;
        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            while (sum > n) {
                sum -= lt++;
            }
            if(sum == n) answer++;
        }

        System.out.println(answer);

    }
}
