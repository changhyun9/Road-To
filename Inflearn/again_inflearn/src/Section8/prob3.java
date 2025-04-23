package Section8;

import java.io.*;
import java.util.*;

public class prob3 {
    static int n, m, answer;
    static Problem[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Problem[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[i] = new Problem(score, time);
        }

        DFS(0, 0, 0);

        System.out.println(answer);
    }

    static void DFS(int time, int sum, int L) {
        if(time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(time + arr[L].time, sum + arr[L].score, L + 1);
            DFS(time, sum, L + 1);

        }
    }
}

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}