package Section2;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] scores = new int[n];
        int[] answer = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 강의 해설 이중 for문으로 나보다 높은 점수가 있으면 cnt++ 해주고 저장

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if(scores[i] < scores[j]) cnt++;
            }
            answer[i] = cnt;
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
