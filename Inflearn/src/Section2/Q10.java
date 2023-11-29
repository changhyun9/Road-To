package Section2;

import java.util.Scanner;

public class Q10 {
    /**
     * 내가 구현한 방법
     * 격자판의 각 사이드는 0으로 초기화되므르 입력받은 격자판의 사이즈에 상하좌우로 한줄씩 추가된다
     * 따라서 격자판의 사이즌 N+2만큼 설정된다. 이후 한칸씩 띄워진 만큼 0~N+1을 탐색하는 것이 아닌
     * 1~N만큼 탐색한다. 각 지점에서 상보다 큰경우에 하를 보고, 하보다 큰 경우에 좌를 보고,
     * 좌보다 큰 경우에 우를 보면서 필요없는 연산 횟수를 줄인다. 모든 경우를 통과한 경우에만 봉우리의 개수를
     * 1 증가시킨다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mountain = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                mountain[i][j]= sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(mountain[i][j] > mountain[i-1][j]){
                    if(mountain[i][j] > mountain[i+1][j]){
                        if (mountain[i][j] > mountain[i][j-1]){
                            if (mountain[i][j] > mountain[i][j+1]){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
    /**
     * 상하좌우를 보면서 값이 큰지 확인하는 방향성은 같지만
     * 해당 방법을 구현하는 코드가 다른다. 나는 if문을 중첩으로 사용했고
     * 강의에서는 방향을 미리 배열로 선언하여 반복문을 돌렸다
     * 또한, 나는 가장자리를 처리하기 위해 임의로 더 큰 격자판을 만들었지만
     * 강의에서는 조건식을 사용하여 처리하였다
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mountain = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mountain[i][j]= sc.nextInt();
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && mountain[nx][ny] >= mountain[i][j]) {
                        flag=false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }*/
}
