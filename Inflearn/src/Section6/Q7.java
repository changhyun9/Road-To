package Section6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q7 {
    /**
     * 나의 구현방법
     * 두 개의 배열을 받아서 각각 x,y 좌표를 저장하고
     * 우선적으로 x 좌표를 통해서 정렬을 진행한다.
     * 이후 같은 x 좌표를 가진 경우에만 y 좌표를 통해서
     * 정렬을 진행.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for (int i = N-1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j + 1] = temp;
                    temp = y[j];
                    y[j] = y[j + 1];
                    y[j + 1] = temp;
                } else if (x[j] == x[j+1]) {
                    if (y[j] > y[j + 1]) {
                        int temp = x[j];
                        x[j] = x[j+1];
                        x[j + 1] = temp;
                        temp = y[j];
                        y[j] = y[j + 1];
                        y[j + 1] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(x[i] + " " + y[i]);
        }
    }
    /**
     * 강의 구현법
     * x,y 값을 갖는 Point 객체를 생성하는데, Comparable 인터페이스를
     * 구현하여 compareTo 메서드를 재정의 하여 간단하게 정렬기준을 설정한다.
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }*/
}

/*class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}*/
