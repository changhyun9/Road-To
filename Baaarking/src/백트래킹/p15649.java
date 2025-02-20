package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {
    static int[]  temp;
    static boolean[] num;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new boolean[n+1];
        temp = new int[m];
        tracking(0);
    }

    public static void tracking(int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!num[i]) {
                    temp[level] = i;
                    num[i] = true;
                    tracking(level + 1);
                    num[i] = false;

                }

            }
        }
    }
}
