package Section8;

import java.io.*;
import java.util.*;

public class prob14 {

    static int n, m, answer = Integer.MAX_VALUE;
    static List<Point> pizzas = new ArrayList<>();
    static List<Point> homes = new ArrayList<>();
    static int[] ch, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) homes.add(new Point(i,j));
                if(num == 2) pizzas.add(new Point(i,j));
            }
        }

        ch = new int[pizzas.size()];
        arr = new int[m];

        DFS(0,0);

        System.out.println(answer);

    }

    public static void DFS(int L, int idx) {
        if (L == n) {
            int sum = 0;
            for (Point home : homes) {
                int dist = Integer.MAX_VALUE;
                for (int num : arr) {
                    dist = Math.min(dist,
                            Math.abs(home.x - pizzas.get(num).x) + Math.abs(home.y - pizzas.get(num).y));
                }
                sum += dist;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = idx; i < pizzas.size(); i++) {
                    arr[L] = i;
                    DFS(L+1, i+1);
            }
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
