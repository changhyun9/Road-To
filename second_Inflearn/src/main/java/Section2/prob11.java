package Section2;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] friends = new int[n+1][6];
        int answer = 0;
        int max = 0;


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= 5; j++) {
                friends[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 강의 해설 i,j를 비교해서 1학년부터 5학년 까지 비교하면서 같으면 cnt 증가시켜주고, break 함
        // 그래서 가장 많은 cnt를 가진 인덱스를 정답으로 설정

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (friends[i][k] == friends[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (max < cnt) {
                max = cnt;
                answer = i;
            }
        }



        System.out.println(answer);



    }
}
