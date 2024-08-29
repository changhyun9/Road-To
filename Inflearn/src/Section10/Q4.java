package Section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    /**
     * 나의 구현방법 -> 못품
     * 강의 해설 -> 변수 2개를 기준으로 부분 증가 수열을 찾아야하지만,
     * 미리 벽돌의 밑면 크기를 기준으로 정렬을 시키고, 벽돌의 무게만으로
     * LIS, 최대 부분 증가 수열을 진행한다. 이전 문제와 차이점은
     * 객체를 생성하고, 벽돌의 밑면을 사용하여 미리 정렬한다는 것을 제외하고는
     * 모든 로직이 같음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Block> list = new ArrayList<>();
        int[] value = new int[n];
        int answer;

        for (int i = 1; i <= n; i++) {
            int size = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            list.add(new Block(size, height, weight));
        }

        Collections.sort(list);
        value[0] = list.get(0).h;
        answer = value[0];

        for (int i = 1; i < n; i++) {
            int max_h = 0;
            // 역순으로 접근 해줘야 함.나중에 오는 것이 더 작은 값이기 때문에 역순으로 접근해야 LIS를 찾을 수 있음.
            for (int j = i-1; j >= 0; j--) {
                if(list.get(j).w > list.get(i).w && max_h < value[j]) max_h = value[j];
            }
            value[i] = max_h + list.get(i).h;
            answer = Math.max(answer, value[i]);
        }

        System.out.println(answer);
    }
}

class Block implements Comparable<Block> {
    int s;
    int h;
    int w;

    public Block(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Block o) {
        return o.s - this.s;
    }
}