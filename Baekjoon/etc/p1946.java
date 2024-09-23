package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1946 {
    /**
     * 나의 구현방법
     * 이전에 풀었던 회의실 배정 문제와 같은 로직으로 풀었음.
     * 임의의 클래스를 만들어서 두개의 멤버변수 중 하나를 기준으로 미리 정렬을 진행.
     * 이후, 나머지 멤버변수를 통해서 답을 구함. 반복문을 진행하면서 더 작은 값이 있을 경우에
     * 정답 수를 증가하고, 최소값을 변경함.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int cnt = 0; cnt < T; cnt++) {
            int N = sc.nextInt();
            List<Employee> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int doc = sc.nextInt();
                int meet = sc.nextInt();
                list.add(new Employee(doc, meet));
            }
            Collections.sort(list);
            int answer=1;
            int min = list.get(0).meet;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).meet < min) {
                    min = list.get(i).meet;
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}

class Employee implements Comparable<Employee> {
    int doc;
    int meet;

    public Employee(int doc, int meet) {
        this.doc = doc;
        this.meet = meet;
    }

    public int compareTo(Employee obj) {
        return this.doc - obj.doc;
    }
}
