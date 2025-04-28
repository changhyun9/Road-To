package DFSandBFS;

import java.io.*;
import java.util.*;

public class p1759 {
    static int L,C;
    static char[] ch, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new char[C];
        tmp = new char[C];

        String[] split = bf.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            ch[i] = split[i].charAt(0);
        }
        Arrays.sort(ch);
        DFS(0, 0);
    }

    static void DFS(int Level, int idx) {
        if (Level == L) {
            if (check()) {
                for (int i = 0; i < L; i++) {
                    System.out.print(tmp[i]);
                }
                System.out.println();
            }
        } else {
            for (int i = idx; i < C; i++) {
                tmp[Level] = ch[i];
                DFS(Level + 1, i + 1);
            }
        }
    }

    static boolean check() {
        int aCnt = 0, nCnt = 0;
        for (int i = 0; i < L; i++) {
            if (tmp[i] == 'a' || tmp[i] == 'e' || tmp[i] == 'i' || tmp[i] == 'o' || tmp[i] == 'u') {
                aCnt++;
            } else {
                nCnt++;
            }
        }

        if (aCnt >= 1 && nCnt >= 2) {
            return true;
        }
        return false;
    }
}
