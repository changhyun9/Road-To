package Section8;

import java.io.*;
import java.util.*;

public class prob1 {
    static int n, total;
    static int[] arr, ch;
    static String answer = "NO";
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        ch = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int idx) {
        if (idx == n) {
            int used = 0, unused = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    used += arr[i];
                } else {
                    unused += arr[i];
                }
            }

            if (used == unused) {
                answer = "YES";
            }

        } else {
            ch[idx] = 1;
            DFS(idx + 1);
            ch[idx] = 0;
            DFS(idx + 1);
        }
    }


    // 강의 해설 check 배열을 사용하지 않고, 인자에 포함되는 경우의 수를 미리 포함하여 전송.
    // 그리고 YES 라는 답을 찾았으면, flag 값을 변경하여 더이상 재귀를 돌지 않도록 구현
    static void solution(int L, int sum) {
        if(flag) return;
        if(sum > total / 2) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            solution(L + 1, sum + arr[L]);
            solution(L + 1, sum);
        }
    }
}
