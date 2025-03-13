package Section8;

import java.io.*;
import java.util.*;

public class prob3 {
    static int n, m, answer;
    static Prob[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Prob[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Prob(a,b);
        }

        DFS(0, 0,0);
        System.out.println(answer);

    }

    static void DFS(int L, int t, int s) {
        if(t > m) return;
        if (L == n) {
            answer = Math.max(answer, s);
        } else {
            DFS(L + 1, t + arr[L].t, s + arr[L].s);
            DFS(L + 1, t, s);
        }
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
