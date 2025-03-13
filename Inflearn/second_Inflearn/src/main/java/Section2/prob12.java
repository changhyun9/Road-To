package Section2;

import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 강의 해설 4중 for문을 이용해 모든 경우의 수에 대해 m번의 테스트에서 앞서는지 확인

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) { // 여기까지 for문이 모든 경우의 수 (1,1) ~ (n,n)까지
                int cnt = 0;
                for (int k = 0; k < m; k++) { // 모든 테스트를 확인하는 for문
                    int pi = 0, pj = 0;
                    for (int p = 0; p < n; p++) { // 하나의 테스트 안에서 등수를 확인하는 for문
                        if(arr[k][p] == i) pi = p;
                        if(arr[k][p] == j) pj = p;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) answer++;
            }
        }

        System.out.println(answer);

    }
}
