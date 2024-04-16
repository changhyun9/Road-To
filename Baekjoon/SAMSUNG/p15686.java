package SAMSUNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15686 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static List<Point> house = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    house.add(new Point(i, j));
                }
                if (tmp == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }
        selected = new int[m];

        len = pizza.size();
        DFS(0, 0);

        System.out.println(answer);
    }

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum =0;
            for (Point p : house) {
                int dis = Integer.MAX_VALUE;
                for (int i : selected) {
                    dis = Math.min(dis, Math.abs(p.x - pizza.get(i).x) + Math.abs(p.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                selected[L] = i;
                DFS(L + 1, i + 1);
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
