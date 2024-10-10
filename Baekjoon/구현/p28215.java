package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p28215 {
    /**
     * 나의 구현방법
     * 처음 문제보자마자 삼성 기출문제인 '치킨 배달' 을 떠올렸다.
     * 문제를 보고 접근을 똑같이 해봤는데 방법이 거의 일치했다.
     * 각 대피소 별 최소거리 중 최대 값을 찾는 과정에서 조금 애를 먹었고
     * 이후, 찾은 최대값 중 최소값을 answer에 저장하는 것에 살짝 시간 지체가 됐지만
     * 문제없이 해결했다. 근데 N과 K가 같을 경우에는 0을 출력해야하는데
     * 나는 MIN_VALUE 로 설정해놔서 문제가 자꾸 틀렸다. 이 조건을 보지못하고
     * 지나가서 많은 시간을 보냈다. 문제 분석할 때 조금더 자세하게 분석하는 연습을 해야겠다.
     */
    static int N, K, answer = Integer.MAX_VALUE, dis;
    static List<Coord> home = new ArrayList<>();
    static int[] shelter, mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        shelter = new int[K];
        mem = new int[N - K];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            home.add(new Coord(x, y));
        }

        for (int i = 0; i < N; i++) {
            shelter[0] = i;
            DFS(i, 1);
        }

        if (N == K) {
            answer = 0;
        }
        System.out.println(answer);
    }

    public static void DFS(int index, int level) {
        if (level == K) {
            int cnt=0;
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                dis = Integer.MAX_VALUE;
                for (int num : shelter) {
                    if (i == num) {
                        flag = true;
                        break;
                    }
                    Coord temp = home.get(num);
                    dis = Math.min(dis, Math.abs(home.get(i).x - temp.x) + Math.abs(home.get(i).y - temp.y));
                }
                if (!flag) {
                    mem[cnt++] = dis;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i : mem) {
                max = Math.max(max, i);
            }
            answer = Math.min(answer, max);
        } else {
            for (int i = index+1; i < N; i++) {
                shelter[level] = i;
                DFS(i, level+1);
            }
        }
    }
}

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}