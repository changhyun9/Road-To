package Section8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15 {
    /**
     * 강의 구현방법
     * 입력을 받는 이중 for문을 돌면서, 1일때는 house List에 저장, 2일때는 pizza List에 저장
     * 이후 pizza List에서 M만큼만 선택하여 selected 배열을 구성하는 조합 DFS 진행
     * 이후, selected 배열과 모든 집과 거리연산을 거쳐 각 집마다 최소값 dis를 구함
     * 모든 조합에 대해 구한다음 모든 집에 대한 배달거리인 sum이 최소가 되는 값을 저장
     */
    static int n, m, len, answer = Integer.MAX_VALUE;
    static List<Point> house = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m]; // pizza집 총 개수중 M개를 선택하여 저장하는 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                // 여기도 키포인트 중 하나일듯, board와 같은 2차원 배열을 안쓰고, 각각의 위치를 가지는 ArrayList를 떠올리는 것
                if(tmp == 1) house.add(new Point(i,j));
                if(tmp == 2) pizza.add(new Point(i,j));
            }
        }
        len = pizza.size(); // why len이 필요한가 ?
        DFS(0, 0); // why 0,0 인가?
        System.out.println(answer);
    }

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : house) { // 코테 문제를 풀때 이부분을 떠올리는 것이 중요할듯, 조합이랑
                int dis = Integer.MAX_VALUE;
                for (int i : selected) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            // len까지 도는 이유는 모든 pizza 집을 대상으로 하기 떄문에
            // i가 s부터 시작되는 이유는 DFS(L+1, i+1)부터 시작하기 떄문에 계속해서 i=0부터 시작하는게 아니고
            // 이전에 포함하거나, 포함하지 않은 배열은 지나치고, 다음부터 저장하기 위함
            for (int i = s; i < len; i++) { // 이부분이 어떻게 조합을 만들어 내는지
                selected[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
