package 탐색;

import java.util.Arrays;
import java.util.Scanner;

public class p1759 {
    /**
     * 나의 구현방법 -> 못품
     * 입력 후, 정렬된 알파벳을 백트래킹 하는 것까지 도출해냈는데, 최소 하나 이상의 모음,
     * 최소 두개 이상의 자음 포함조건을 어떻게 해야할 지 몰라서 검색을 했음.
     * 근데 단순히 하나의 메서드를 구현해서 조건을 탐색함.
     * 어제 풀었던 적녹색약 문제도 그렇고 단순하게 생각하는 것도 필요할 듯.
     */
    static int L, C;
    static char[] arr, check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();

        String[] split = number.split("\\s");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        arr = new char[C];
        check = new char[L];

        String alpha = sc.nextLine();
        String[] bet = alpha.split("\\s");

        for (int i = 0; i < bet.length; i++) {
            arr[i] = bet[i].charAt(0);
        }

        Arrays.sort(arr);
        DFS(0, 0);
    }

    public static void DFS(int level, int index) {
        if (level == L) {
            if (check()) {
                for (char c : check) {
                    System.out.print(c);
                }
                System.out.println();
            }
        } else {
            for (int i = index; i < C; i++) {
                check[level] = arr[i];
                DFS(level+1, i+1);
            }
        }
    }

    public static boolean check() {
        int j=0;
        int m=0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 'a' || check[i] == 'e' || check[i] == 'i' || check[i] == 'o' || check[i] == 'u') {
                m++;
            } else {
                j++;
            }
        }
        if(m>=1 && j>=2) return true;
        return false;
    }
}