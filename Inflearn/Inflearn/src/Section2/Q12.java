package Section2;

import java.util.Scanner;

public class Q12 {
    /**
     * 내가 구현한 방법
     * 사람을 기준으로 모든 시험에서의 등수를 체크한다.
     * 1등을 기준으로 뒤에 있는 사람들의 배열을 증가시킨다.
     * 모든 시험 횟수의 M번을 진행하고, 증가된 값이 M과 같은지 판별한다
     * 값이 M이라면 M번의 시험에서 기준이 되는 등수보다 뒤에 있다는 것을 뜻한다
     * 1등, 2등 ,,, N등 까지 모든 사람을 기준으로 N번 진행한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grade = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grade[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        int[] student = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int num = grade[0][i];
            for (int j = 0; j < M; j++) {
                boolean flag = false;
                for (int k = 0; k < N; k++) {
                    if (grade[j][k] == num) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        student[grade[j][k]]++;
                    }
                }
            }
            for (int j = 1; j <=N; j++) {
                if (student[j] == M) {
                    answer++;
                }
                student[j] = 0;
            }
        }
        System.out.println(answer);
    }

    /**
     * 멘토, 멘티가 될수 있는 모든 경우의 수를 돌면서
     * A학생이 B학생보다 모든 시험에서 앞서 있는지 확인함.
     * 모두 앞서 있다면, 결과값을 증가시킴.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grade = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grade[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    int pi=0, pj=0;
                    for (int s = 0; s < N; s++) {
                        if (grade[k][s] == i) {
                            pi = s;
                        }
                        if (grade[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == M) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }*/
}
