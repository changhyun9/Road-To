package Section3;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    /**
     * 내가 구현한 방법
     * 두개의 배열을 입력받아서, 두 개의 배열 사이즈를 더한 만큼의
     * 새로운 배열을 생각한다. 두개의 포인터를 두고, 각 포인터가 가리키는
     * 값을 비교하여 작은 값부터 삽입하고 다음 요소를 가리키도록 한다.
     * 1번 케이스에서 런타임 에러가 뜸. -> 한쪽 배열의 포인터가 먼저 배열의 끝에 도달한 경우
     * 다른 한쪽의 배열으로만 채워야 하는데 해당 경우의 수를 고려하지 않음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] first = new int[N];
        for (int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] second = new int[M];
        for (int i = 0; i < M; i++) {
            second[i] = sc.nextInt();
        }

        int total = N + M;
        int p1 = 0, p2 = 0;
        int[] third = new int[total];
        for (int i = 0; i < total; i++) {
            if(p1 < N && p2 < M){
                if (first[p1] < second[p2]) {
                    third[i] = first[p1];
                    p1++;
                } else{
                    third[i] = second[p2];
                    p2++;
                }
            }
            else{
                if(p1 < N){
                    third[i] = first[p1];
                    p1++;
                }
                else{
                    third[i] = second[p2];
                    p2++;
                }
            }
        }

        for (int i = 0; i < total; i++) {
            System.out.print(third[i] + " ");
        }
    }

    /**
     * 내가 구현한 방법 (라이브러리 이용), two-pointer X
     * 두개의 배열을 System.arrayCopy로 합치고
     * Arrays.sort()로 오름 차순 정렬을 한다
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] first = new int[N];
        for (int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] second = new int[M];
        for (int i = 0; i < M; i++) {
            second[i] = sc.nextInt();
        }

        int total = N + M;
        int[] result = new int[total];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        Arrays.sort(result);

        for (int one : result) {
            System.out.print(one + " ");
        }
    }*/
}
