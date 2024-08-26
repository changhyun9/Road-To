package Section9;

import java.util.Scanner;

public class Q6 {
    /**
     * 나의 구현방법 -> 못품
     * 강의해설 -> union & find 방법을 이용해서 문제를 해결
     * unf이라는 전역변수로 배열을 만든 후, 각 인덱스를 통해 해당 인덱스가
     * 포함되어 있는 집합의 번호를 저장한다. 이후 입력받는 친구 쌍의 값에 따라
     * 집합의 인덱스를 변경한다. union 함수는 두 입력 값을 find 함수를 호출하여
     * 포함되어 있는 집합의 인덱스를 확인하고, 두 값의 집합을 연결하고,
     * 최적화하는 메서드이다.
     */

    static int[] unf;
    public static int Find(int v) {
        if(v == unf[v]) return v; // 해당 친구가 본인의 집합 인덱스를 가지고 있으면 그냥 해당 값 리턴
        else return unf[v] = Find(unf[v]); // 해당 친구가 본인의 집합 인덱스가 아닌 다른 친구의 인덱스를 가지고 있으면, 해당 값의 친구로 가서
        // 해당 값을 가져오고, 경로 최적화를 위해 값을 변경함.
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb; // 친구의 쌍 값을 받아서 두 친구를 같은 집합에 속하도록 구현
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i; // 해당 변수의 인덱스가 친구의 인덱스 번호와 일치시키도록 작성
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a,b); // 친구 쌍을 입력받아 같은 집합에 속하도록 함수 호출
        }

        int friend1 = sc.nextInt();
        int friend2 = sc.nextInt();

        if (Find(friend1) == Find(friend2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

