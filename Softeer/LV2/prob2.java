package LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob2 {
    /**
     * 문제명 : 나무 공격
     * 나의 풀이 방법 : 처음에는 DFS 혹은 BFS 로 푸는 문제인 줄 알았는데, 특정 행에서 반복되는 작업이기에
     * 완전 탐색으로 문제를 풀었다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        String nm = bf.readLine();
        String[] split = nm.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n+1][m+1];
        int answer =0;

        for(int i=1; i<=n; i++){
            String input = bf.readLine();
            String[] numbers = input.split(" ");
            for(int j=0; j<m; j++){
                map[i][j+1] = Integer.parseInt(numbers[j]);
            }
        }

        for(int i=0; i<2; i++){
            String rangeInput = bf.readLine();
            String[] range = rangeInput.split(" ");
            int x = Integer.parseInt(range[0]);
            int y = Integer.parseInt(range[1]);

            for(int j=x; j<=y; j++){
                for(int k=1; k<=m; k++){
                    if(map[j][k] == 1){
                        map[j][k] = 0;
                        break;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == 1){
                    answer ++;
                }
            }
        }

        System.out.println(answer);

    }
}
