package Section7;

import java.io.*;
import java.util.*;

public class prob6 {
    static int n;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        ch = new int[n + 1];

        DFS(1);
    }

    // 강의 해설 check 배열을 통해서 해당 인덱스를 사용하는 DFS와 사용하지 않는 DFS를 2가지 갈래로 분기하여
    // 재귀를 호출. 재귀를 호출할 때 상태 트리 => 2가지 경우를 갖는 트리

    static void DFS(int L) {
        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }

    }
}
