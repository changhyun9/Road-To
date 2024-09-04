package 탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p2805 {
    /**
     * 나의 구현방법
     * 이분탐색을 이용하여 문제를 풀었다. 처음엔 어떤 식으로 풀어야할지 몰라서 알고리즘 분류를 보고 접근했다.
     * 처음엔 인덱스로 접근했는데, list안에 있는 값으로 해결되지 않을 경우가 있어 list에 있는 value로
     * 재접근해서 풀었다. mid 값을 구하고, list 안에 있는 값보다 작은 경우에만 해당 값과의 차를 구해서
     * 더해주었다. 그 값을 통해서 mid 값을 조정하였고, 답을 구했다. 그리고, lt와 rt가 교차되어서 넘어가는
     * 경우 '적어도' 해당 높이만큼 값을 구해야하기 때문에 lt -1 만큼 해주었다. 그리고 반례를 못찾아서 질문게시판을
     * 통해 반례를 확인하였고, int형으로 받다가 오버플로우가 나는 경우, 같은 값이 중복돼서 들어오는 경우를 찾지 못해서
     * int에서 long 값으로 변경하였고, 처음 lt 시작을 리스트의 처음 값으로 설정했는데, 무조건 0으로 설정해서
     * 답을 구할 수 있었다.
     */
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 0) {
                list.add(num);
            }
        }

        Collections.sort(list);

        int lt = 0;
        int rt = list.get(list.size() - 1);

        boolean flag = false;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            long count = count(mid);

            if (count > M) {
                lt = mid + 1;
            } else if (count == M) {
                flag = true;
                System.out.println(mid);
                break;
            } else {
                rt = mid - 1;
            }
        }

        if (!flag) {
            System.out.println(lt - 1);
        }

    }

    public static long count(long value) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > value) sum += (list.get(i) - value);
        }
        return sum;
    }
}
