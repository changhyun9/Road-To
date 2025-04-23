package Section10;

import java.io.*;
import java.util.*;

public class prob4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Block[] arr = new Block[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Block(s, h, w);
        }

        Arrays.sort(arr);

        dp[0] = arr[0].h;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i].w < arr[j].w) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + arr[i].h;
        }

        int answer = 0;
        for (int num : dp) {
            answer = Math.max(answer, num);
        }
        System.out.println(answer);

    }
}

class Block implements Comparable<Block> {
    int s;
    int h;
    int w;

    public Block(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Block o) {
        return o.s - this.s;
    }
}