package Section10;

import java.io.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] dy = new int[n];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && max < dy[j]) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}
