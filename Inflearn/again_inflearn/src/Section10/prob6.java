package Section10;

import java.io.*;
import java.util.*;

public class prob6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Prob[] arr = new Prob[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new Prob(s, t);
        }

        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            Prob obj = arr[i];
            for (int j = m; j >= obj.t; j--) {
                dp[j] = Math.max(dp[j], dp[j - obj.t] + obj.s);
            }
        }

        System.out.println(dp[m]);

    }
}

class Prob{
    int s;
    int t;

    public Prob(int s, int t) {
        this.s = s;
        this.t = t;
    }
}