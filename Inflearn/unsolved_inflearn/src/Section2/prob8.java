package Section2;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] scores = new int[n];


        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for (int score : scores) {
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if(score < scores[i]) cnt++;
            }
            System.out.print(cnt + " ");
        }
    }
}
