package Section2;

import java.util.Scanner;

public class Q9 {
    /**
     * 내가 구현한 방법
     * 점수를 입력받고, 가로 열을 모두 더한뒤 최대값과 비교하여 판정하고
     * 세로 행을 모두 더한뒤 최대값을 비교하여 판정한다.
     * 또한, 대각선 합을 저장하는 변수를 만들어서 모든 반복문을 수행할때까지
     * 조건에 만족하면 값을 더해서 구하고, 마지막에 최대값과 비교하여 판정한다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        int crossSum =0;
        int reverseCrossSum =0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += grid[i][j];
                if(i == j){
                    crossSum += grid[i][j];
                }
                if(i+j == N){
                    reverseCrossSum += grid[i][j];
                }
            }
            if (max < sum) {
                max = sum;
            }
            sum =0;
            for (int j = 0; j < N; j++) {
                sum += grid[j][i];
            }
            if (max < sum) {
                max = sum;
            }
        }
        if(crossSum > max) {
            max = crossSum;
        }
        if(reverseCrossSum > max){
            max = reverseCrossSum;
        }
        System.out.println(max);
    }

    /**
     * 가로 행의 합과 세로 열의 합과 두 대각선의 합을 구해서 최대값을 구하는 것은 같다.
     * 하지만, 구현 방법에서 차이가 난다. 나는 하나의 이중 포문으로 모든 케이스를 커버하였고
     * 강의에서는 가로, 세로는 같은 포문을 사용했지만, 대각선의 합을 구할 때에는 다른 하나의
     * 포문을 이용하여 구하였다. 또한, 나는 if문을 통해 최대값을 비교하였지만, 강의에서는 Math의
     * max()를 사용해서 값을 비교하고 저장하였음.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = Integer.MIN_VALUE;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int sum1, sum2;
        for (int i = 0; i < N; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < N; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 =0;
        sum2 =0;
        for (int i = 0; i < N; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][N - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        System.out.println(answer);
    }*/
}
