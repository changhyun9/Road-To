package Section3;

import java.util.Scanner;

public class Q6 {
    /**
     * 내가 구현한 방법
     * lt와 rt 두개의 포인터를 설정하고, rt는 0을 K번을 바꿀수 있도록 계속해서
     * 옮기면서 1이면 증가하고, 0 이면 K를 하나 감소하고 K가 -1이 될때까지 이동한다
     * 이때 lt와 rt의 거리를 구하고, 최대값과 비교해서 값을 설정한다.
     * 이후 lt를 앞으로 옮기면서 k가 0일 때까지 이동한다.
     * rt가 K=-1까지 이동했다는 것은 0을 최대로 바꾼후 다시 0을 만난 상태라는 것이다.
     * lt가 K=0이 될때까지 이동했다는 것은 lt와 현재 rt 사이에 있는 0은 모두 바꿀수 있고,
     * rt가 다시 앞으로 옮기면서 0을 만나기 까지 갈 수 있다는 것이다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0, rt = 0;
        int max = Integer.MIN_VALUE;
        while (rt < N) {
            if (K == -1) {
                int distance = rt - lt -1 ;
                max = Math.max(max, distance);
                while (K < 0) {
                    if (arr[lt] == 1) {
                        lt++;
                    } else {
                        lt++;
                        K++;
                    }
                }
            }
            if (K != -1) {
                if (arr[rt] == 1) {
                    rt++;
                } else {
                    rt++;
                    K--;
                }
            }
        }
        System.out.println(max);
    }

    /**
     * 해결 로직은 같고, 세부 구현법이 다름
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt =0, lt=0, answer =0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > K) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }*/
}
