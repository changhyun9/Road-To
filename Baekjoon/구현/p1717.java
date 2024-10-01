package 구현;

import java.util.Scanner;

public class p1717 {
    /**
     * 나의 구현방법
     * 처음에 이중리스트를 사용하여 구현하니까 메모리 초과가 나옴. n이 1,000,000라 예상한 문제였음.
     * 풀지 못해서 검색을 통해 구현방법을 확인함. -> 유니온 파인드 문제
     */
    static int[] unf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }


        for (int i = 0; i < M; i++) {
            int method = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (method == 0) {
                Union(a,b);
            } else {
                if (Find(a) == Find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }
    public static int Find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
}
