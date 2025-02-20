package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        System.out.println((1 << n) - 1);

        hanoi(1, 3, n);
    }

    public static void hanoi(int a, int b, int n) {
        if (n == 1) {
            System.out.println(a + " " + b);
            return;
        }
        hanoi(a, 6 - a - b, n - 1);
        System.out.println(a + " " + b);
        hanoi( 6 - a - b, b,n - 1);

    }
}
