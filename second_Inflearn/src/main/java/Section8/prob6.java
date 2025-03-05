package Section8;

import java.io.*;
import java.util.*;

public class prob6 {
    static int n, m;
    static int[] arr, ch, pm;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        solution(0);

    }

    static void DFS(int L) {
        if (L == m) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                    DFS(L+1);
                    list.remove((Integer)arr[i]);
                }

            }
        }
    }

    // 강의 해설 arr, ch, pm 3개이 배열을 사용해서 문제풀이
    static void solution(int L) {
        if (L == m) {
            for (int num : pm) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
