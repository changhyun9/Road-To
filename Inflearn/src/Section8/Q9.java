package Section8;

import java.util.Scanner;

public class Q9 {
    /**
     * 나의 구현방법
     * 못품. 인덱스로 주어지는 다음부터 for문을 실행하는 로직은 생각했으나
     * 재귀의 종료조건을 생각해내지 못함. 강의해설을 듣고 코드를 작성.
     * 강의해설 : 재귀를 진행할 때, Level과 start index를 인자로 하여 전달
     * 해당 Level은 조합의 나오는 순서, 배열의 인덱스를 뜻하고 start index부터
     * for문을 실행하여 마지막 숫자까지 진행한다. 이후, Level이 모두 채워지지 않았을 때
     * 다음 재귀로 전달하는 인자는 Level + 1, start index + 1을 전달한다.
     * DFS부분에서 재귀호출을 진행할 때, 두번째 인자는 i에 +1을 해서 전달해야 한다.
     */
    static int[] combi;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];

        DFS(0, 1);

    }

    public static void DFS(int level, int index) {
        if (level == m) {
            for (int num :combi){
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = index; i <= n; i++) {
                combi[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }
}