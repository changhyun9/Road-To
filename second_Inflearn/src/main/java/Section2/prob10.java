package Section2;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (map[i][j] > map[i][j - 1]) {
//                    if (map[i][j] > map[i][j + 1]) {
//                        if (map[i][j] > map[i - 1][j]) {
//                            if(map[i][j] > map[i+1][j]) answer++;
//                        }
//                    }
//                }
//            }
//        }

        // 강의 해설 dx[], dy[]를 이용해서 구함, 그리고 경계선을 if문으로 검색해서 n 크기 만큼만 생성

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] >= map[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        System.out.println(answer);

    }
}
