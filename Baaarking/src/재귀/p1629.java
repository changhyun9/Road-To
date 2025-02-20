package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // int answer1 = func(a, b, c);
        Long answer2 = answer((long)a,(long) b, (long)c);

        System.out.println(answer2);

    }

    public static int func(int a, int b, int c) {
        int val = 1;
        while (b-- != 0) {
            val = (val * a) % c;
        }

        return val;
    }

    public static Long answer(Long a, Long b, Long m) {
        if (b == 1) {
            return a % m;
        }
        long val = answer(a, b / 2, m);
        val = val * val % m;
        if (b % 2 == 0) {
            return val;
        }
        return val * a % m;

    }
}
