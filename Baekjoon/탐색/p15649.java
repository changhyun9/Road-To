package 탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15649 {
    /**
     * 처음에 N 크기의 배열을 생성해서 index별로 포함되면 1로 변경하고, 1로 표시된 것만 출력했는데 시간초과 발생.
     * 그래서 M개의 크기의 배열을 생성해서 하나씩 집어넣는 식으로 변경했지만 마찬가지로 시간초과.
     * 두번째 방식에서 반복문이 많이 사용되는 것 같아 배열이 아닌 리스트로 변경했음.
     * Integer를 제네릭스로 받는 리스트를 생성했는데 매개변수로 int형을 넘겨주면 index인지, element인지 구별을
     *  못하는 상황이 발생해서, String으로 변경해서 성공. 이후 (Object)으로 형변환해서 넣어도 성공하는지 해보았는데
     *  시간초과 발생. 형변환하는 시간이 생겨서 그런가봄.
     */
    static List<String> arr;
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i+"");
            back();
            arr.remove(i+"");
        }

    }

    static void back() {
        if (arr.size() == M) {
            for (String i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (!arr.contains(i + "")) {
                    arr.add(i + "");
                    back();
                    arr.remove(i + "");
                }
            }
        }
    }
}
