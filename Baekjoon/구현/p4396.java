package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p4396 {
    /**
     * 조건을 잘못읽음.
     * 문제를 정확히 파악하고, 조건을 확인하는 습관을 들일 것
     */
    public static void main(String[] args) throws Exception {
        int[] dx = {0,0,-1,1,-1,1,-1,1};
        int[] dy = {-1,1,0,0,1,1,-1,-1};

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        char[][] click = new char[n][n];
        char[][] result = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i],'.' );
        }


        boolean flag = false;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            click[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++){
                if(click[i][j] == 'x' && map[i][j] != '*'){
                    int cnt =0;
                    for(int k=0; k<8; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny] == '*'){
                            ++cnt;
                        }
                    }
                    result[i][j] = (char)(cnt+'0');;
                } else if (click[i][j] == 'x' && map[i][j] == '*') {
                    flag = true;
                }
            }
        }

        if(flag) {
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == '*') result[i][j] = '*';
                }
            }
        }

        for (char[] chars : result) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }

    }
}