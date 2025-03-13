package Section8;

import java.io.*;
import java.util.*;

public class prob14 {
    static int n, m, answer = Integer.MAX_VALUE;
    static List<Pizza> pizzas = new ArrayList<>();
    static List<Home> homes = new ArrayList<>();
    static int[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Home(i, j));
                }
                if (num == 2) {
                    pizzas.add(new Pizza(i, j));
                }
            }
        }

        pm = new int[m];

        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int L, int idx) {
        if (L == m) {
            int sum = 0;
            for (Home home : homes) {
                int value = Integer.MAX_VALUE;
                for (int i : pm) {
                    value = Math.min(value, Math.abs(home.x - pizzas.get(i).x) + Math.abs(home.y - pizzas.get(i).y));
                }
                sum += value;
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = idx; i < pizzas.size(); i++) {
                pm[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }
}

class Pizza {
    int x;
    int y;

    public Pizza(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Home {
    int x;
    int y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
