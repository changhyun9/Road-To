package Section9;

import java.io.*;
import java.util.*;

public class prob6 {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(bf.readLine());
        int friendA = Integer.parseInt(st.nextToken());
        int friendB = Integer.parseInt(st.nextToken());

        if (find(friendA) != find(friendB)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
